package com.baidu.location;

import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.au;
import com.baidu.location.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.util.EntityUtils;
/* loaded from: classes.dex */
class s implements a0, n {
    private static SimpleDateFormat cV = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    u.a cT;
    au.b cU;
    boolean cW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends t {
        public a() {
        }

        @Override // com.baidu.location.t
        void X() {
        }

        void d(String str) {
            this.c2 = str;
            Y();
        }

        @Override // com.baidu.location.t
        /* renamed from: do */
        void mo112do(boolean z) {
            if (!z || this.cY == null) {
                return;
            }
            try {
                ai aiVar = new ai(EntityUtils.toString(this.cY, "utf-8"));
                if (s.this.cW && aiVar.bJ()) {
                    BDLocation bDLocation = new BDLocation();
                    double[] m20if = Jni.m20if(aiVar.bL(), aiVar.bK(), "gps2gcj");
                    bDLocation.setRadius(aiVar.bM());
                    bDLocation.setLocType(BDLocation.TypeNetWorkLocation);
                    bDLocation.m9case(0);
                    bDLocation.setLongitude(m20if[0]);
                    bDLocation.setLatitude(m20if[1]);
                    bDLocation.setNetworkLocationType("sky");
                    bDLocation.getClass();
                    BDLocation.a aVar = new BDLocation.a();
                    aVar.f11new = aiVar.hz;
                    aVar.f10int = aiVar.hE;
                    aVar.f9if = aiVar.hy;
                    aVar.f6byte = aiVar.hB;
                    aVar.f7do = aiVar.hu;
                    aVar.f12try = aVar.f9if + aVar.f11new + aVar.f10int + aVar.f6byte + aVar.f7do;
                    if (c.aF.equals("all")) {
                        bDLocation.m10if(aVar);
                    }
                    bDLocation.setTime(s.cV.format(new Date()));
                    bDLocation.m8byte(u.au().az());
                    if (ah.bG().bI()) {
                        bDLocation.setDirection(ah.bG().bE());
                    }
                    Message obtainMessage = ak.aF().et.obtainMessage(21);
                    obtainMessage.obj = bDLocation;
                    obtainMessage.sendToTarget();
                }
            } catch (Exception e) {
            }
        }
    }

    public s() {
        this.cT = null;
        this.cU = null;
        this.cW = false;
    }

    public s(u.a aVar, au.b bVar, boolean z) {
        this.cT = null;
        this.cU = null;
        this.cW = false;
        this.cT = aVar;
        this.cU = bVar;
        this.cW = z;
    }

    public void N() {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer(1024);
        String a2 = (this.cU == null || this.cU.m227try() <= 1) ? null : this.cU.a(15);
        if (this.cT != null && this.cT.a()) {
            str = this.cT.m357int();
        }
        if (a2 == null && str == null) {
            return;
        }
        stringBuffer.append("<LocationRQ xmlns=\"http://skyhookwireless.com/wps/2005\"\nversion=\"2.21\"\nstreet-address-lookup=\"full\">\n<authentication version=\"2.2\">\n<key key=\"" + Jni.aW() + "\"\nusername=\"BAIDULOC\"/></authentication>\n");
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append("</LocationRQ>");
        new a().d(stringBuffer.toString());
    }
}
