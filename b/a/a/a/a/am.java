package b.a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class am extends Handler {
    final /* synthetic */ al BA;
    StringBuffer Bz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(al alVar, Looper looper) {
        super(looper);
        this.BA = alVar;
        this.Bz = new StringBuffer(15360);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Context context;
        String b2;
        w wVar;
        SimpleDateFormat simpleDateFormat;
        String str;
        w wVar2;
        try {
            switch (message.what) {
                case 1:
                    String stringBuffer = this.Bz.toString();
                    wVar = al.AW;
                    x xVar = wVar.AX;
                    this.Bz.setLength(0);
                    StringBuffer append = this.Bz.append("LOC_CORE,");
                    simpleDateFormat = this.BA.By;
                    append.append(simpleDateFormat.format(new Date())).append(',').append(xVar.f()).append(',').append(xVar.h()).append(',').append(xVar.e().replaceAll(":", "").toUpperCase()).append(',').append("Lite");
                    if (!o.a(stringBuffer)) {
                        this.Bz.append(stringBuffer);
                    }
                    al alVar = this.BA;
                    StringBuilder append2 = new StringBuilder().append(xVar.c).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(xVar.d).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(xVar.f1084b).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(xVar.f1083a).append(',');
                    str = al.h;
                    StringBuilder append3 = append2.append(str).append(',');
                    wVar2 = al.AW;
                    alVar.a("SYSTEM", append3.append(wVar2.AX.f()).append(',').append(Build.MODEL).append(',').append(Build.VERSION.SDK_INT).toString());
                    break;
                case 2:
                    break;
                case 3:
                    this.Bz.append('$').append((String) message.obj);
                    if (this.Bz.length() >= 15360) {
                        this.BA.a(this.Bz.toString(), false);
                        this.Bz.setLength(0);
                        sendEmptyMessage(1);
                        return;
                    }
                    return;
                case 4:
                    this.BA.a("", true);
                    return;
                case 5:
                    al.b(this.BA);
                    return;
                default:
                    return;
            }
            removeMessages(2);
            al alVar2 = this.BA;
            context = al.f;
            b2 = al.b(context);
            alVar2.a("PERMISSION", b2);
            this.BA.c();
        } catch (Throwable th) {
        }
    }
}
