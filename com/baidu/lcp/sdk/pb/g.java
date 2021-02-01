package com.baidu.lcp.sdk.pb;

import android.content.Context;
import com.baidu.lcp.sdk.pb.LcmPb;
import com.baidu.lcp.sdk.pb.RpcMetaPb;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes3.dex */
public class g {
    public com.baidu.lcp.sdk.connect.b b(com.baidu.lcp.sdk.connect.b bVar, boolean z) {
        bVar.needReplay = z;
        return a(bVar, a(bVar.serviceId, bVar.methodId, bVar.msgId, aU(false)), h(bVar.auJ, aU(false)));
    }

    public com.baidu.lcp.sdk.connect.b g(Context context, long j) {
        long random = (long) ((Math.random() * 1000000.0d) + 10000.0d);
        com.baidu.lcp.sdk.connect.b bVar = new com.baidu.lcp.sdk.connect.b();
        bVar.msgId = random;
        bVar.needReplay = true;
        bVar.serviceId = 1L;
        bVar.methodId = j;
        bVar.auP = j == 1;
        bVar.isHeartbeat = j == 3;
        return a(bVar, a(1L, j, random, aU(false)), h(b(context, random, j), aU(false)));
    }

    private com.baidu.lcp.sdk.connect.b a(com.baidu.lcp.sdk.connect.b bVar, byte[] bArr, byte[] bArr2) {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12 + bArr2.length);
            allocate.put((byte) 108);
            allocate.put((byte) 99);
            allocate.put((byte) 112);
            allocate.put((byte) 1);
            allocate.putInt(bArr.length + bArr2.length);
            allocate.putInt(bArr.length);
            allocate.put(bArr);
            allocate.put(bArr2);
            bVar.auJ = allocate.array();
        } catch (Exception e) {
        }
        return bVar;
    }

    private byte[] a(long j, long j2, long j3, int i) {
        return RpcMetaPb.RpcMeta.newBuilder().a(RpcMetaPb.RpcRequestMeta.newBuilder().ao(j3).am(j).an(j2).bZ(1).build()).ai(j3).bW(i).bY(1).build().toByteArray();
    }

    private byte[] b(Context context, long j, long j2) {
        LcmPb.LcmRequest build;
        if (j2 == 4) {
            return LcmPb.RpcData.newBuilder().b(LcmPb.LcmNotify.newBuilder().ab(j).bQ(2).build()).build().toByteArray();
        }
        if (j2 == 1) {
            try {
                LcmPb.Common common2 = (LcmPb.Common) com.baidu.lcp.sdk.d.a.i(context, false);
                LcmPb.LcmRequest build2 = LcmPb.LcmRequest.newBuilder().ac(j).b(common2).eu(com.baidu.lcp.sdk.d.e.getToken(context)).ad(System.currentTimeMillis()).bS(com.baidu.lcp.sdk.a.d.getLoginOpenType(context)).bT(com.baidu.lcp.sdk.d.e.aN(context)).build();
                com.baidu.lcp.sdk.d.d.d("PbProcessor", "cuid :" + common2.getCuid() + ", device :" + common2.getDeviceType() + ", os:" + common2.getOsVersion() + ", man :" + common2.getManufacture() + ", model :" + common2.getModelType() + ", appId :" + common2.getAppId() + ", app :" + common2.getAppVersion() + ", sdk :" + common2.getSdkVersion() + ", token :" + build2.getToken() + ", net :" + common2.getNetwork() + ", rom :" + common2.getRomVersion() + ", start :" + build2.getStartType() + "，connType :" + build2.getConnType());
                build = build2;
            } catch (Exception e) {
                build = LcmPb.LcmRequest.newBuilder().ac(j).eu(com.baidu.lcp.sdk.d.e.getToken(context)).ad(System.currentTimeMillis()).bS(com.baidu.lcp.sdk.a.d.getLoginOpenType(context)).bT(com.baidu.lcp.sdk.d.e.aN(context)).build();
            }
        } else if (j2 == 2) {
            build = LcmPb.LcmRequest.newBuilder().ac(j).ad(System.currentTimeMillis()).build();
        } else {
            build = LcmPb.LcmRequest.newBuilder().ac(j).ad(System.currentTimeMillis()).build();
        }
        com.baidu.lcp.sdk.d.d.w("PbProcessor", "logId :" + j + ", requestTime :" + build.getTimestamp() + "，methodId :" + j2);
        return LcmPb.RpcData.newBuilder().b(build).build().toByteArray();
    }

    private byte[] h(byte[] bArr, int i) {
        if (i == 1) {
            return B(bArr);
        }
        return bArr;
    }

    private int aU(boolean z) {
        return z ? 1 : 0;
    }

    private byte[] B(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
