package com.baidu.ar.anime;

import android.text.TextUtils;
import com.baidu.ar.anime.a;
import com.baidu.ar.anime.b;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.h.e;
import com.baidu.ar.h.j;
import com.baidu.ar.h.p;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class AnimeAR extends c {
    public static final String TAG = "AnimeAR";
    public LuaMsgListener cc;
    public String bD = null;
    public AlgoHandleController cb = null;
    public b cd = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FramePixels framePixels) {
        AlgoHandleController algoHandleController;
        if (framePixels == null || (algoHandleController = this.cb) == null) {
            return;
        }
        long createHandle = algoHandleController.createHandle();
        this.cb.setHandleInput(createHandle, 21, framePixels.getTimestamp(), 4, framePixels.getWidth(), framePixels.getHeight(), framePixels.isFrontCamera(), framePixels.getSegOrientation().getValue(), false, null);
        byte[] pixelData = framePixels.getPixelData();
        ReserveHandleData reserveHandleData = new ReserveHandleData();
        reserveHandleData.setByteDataSize(1);
        reserveHandleData.setByteWidths(new int[]{framePixels.getWidth()});
        reserveHandleData.setByteHeights(new int[]{framePixels.getHeight()});
        if (p.A(getContext())) {
            pixelData = j.b(e.a(j.a(framePixels.getWidth(), framePixels.getHeight(), pixelData), -90));
            reserveHandleData.setByteWidths(new int[]{framePixels.getHeight()});
            reserveHandleData.setByteHeights(new int[]{framePixels.getWidth()});
        }
        reserveHandleData.setByteFormats(new int[]{2});
        ArrayList arrayList = new ArrayList();
        arrayList.add(pixelData);
        reserveHandleData.setByteArrayListData(arrayList);
        AlgoHandleAdapter.setHandleReserveData(createHandle, reserveHandleData);
        l r = r();
        if (r == null || createHandle <= 0) {
            return;
        }
        String str = TAG;
        com.baidu.ar.h.b.b(str, "origin image setAlgoHandleData:" + createHandle);
        r.a(createHandle, this.bD);
        a(createHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final boolean z, final String str2) {
        final a aVar = new a();
        if (TextUtils.isEmpty(str2) && p.A(getContext())) {
            aVar.an();
        }
        aVar.a(new a.InterfaceC0044a() { // from class: com.baidu.ar.anime.AnimeAR.3
            @Override // com.baidu.ar.anime.a.InterfaceC0044a
            public void b(FramePixels framePixels) {
                AnimeAR.this.a(framePixels);
                if (z && AnimeAR.this.cd != null) {
                    com.baidu.ar.h.b.b(AnimeAR.TAG, "onFramePixelRead and mRequestController.request");
                    AnimeAR.this.cd.a(framePixels, str2);
                }
                new Thread(new Runnable() { // from class: com.baidu.ar.anime.AnimeAR.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        AnimeAR.this.a(aVar);
                    }
                }).start();
            }
        });
        aVar.v(str);
        a(aVar, new com.baidu.ar.d.e() { // from class: com.baidu.ar.anime.AnimeAR.4
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
            }
        });
    }

    private void al() {
        if (this.cc == null) {
            this.cc = new LuaMsgListener() { // from class: com.baidu.ar.anime.AnimeAR.2
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("event_name");
                    return arrayList;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    String str = (String) hashMap.get("event_name");
                    String str2 = (String) hashMap.get("type_name");
                    if ("get_pixel_frame".equals(str)) {
                        String str3 = (String) hashMap.get("filter_id");
                        String str4 = (String) hashMap.get("frame_type");
                        com.baidu.ar.h.b.aS("event_name: " + str + ", filterId: " + str3 + ", frameType:" + str4 + "type_name: " + str2);
                        boolean z = true;
                        if ("get_frame_only".equals(str4)) {
                            z = false;
                        } else {
                            "get_frame_and_request".equals(str4);
                        }
                        AnimeAR.this.a(str3, z, str2);
                    }
                    if ("retry_anime_effect".equals(str)) {
                        com.baidu.ar.h.b.aS("event_name: " + str + " and mRequestController.retryChangeStyle()");
                        if (AnimeAR.this.cd != null) {
                            AnimeAR.this.cd.w(str2);
                        }
                    }
                    if ("cancel_anime_request".equals(str)) {
                        com.baidu.ar.h.b.aS("event_name: " + str + " and mRequestController.cancelAllRequest()");
                        if (AnimeAR.this.cd != null) {
                            AnimeAR.this.cd.ar();
                        }
                    }
                }
            };
        }
        a(this.cc);
    }

    @Override // com.baidu.ar.c
    public void a(long j) {
        AlgoHandleController algoHandleController;
        super.a(j);
        if (j <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j) != 21) {
            return;
        }
        String str = TAG;
        com.baidu.ar.h.b.b(str, "destroyHandle:" + j);
        this.cb.destroyHandle(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(this.cc);
        b bVar = this.cd;
        if (bVar != null) {
            bVar.release();
            this.cd = null;
        }
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController != null) {
            algoHandleController.release();
            this.cb = null;
        }
        l r = r();
        if (r != null) {
            r.q(21);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("setup(luaParams):");
        sb.append(hashMap != null ? hashMap.toString() : null);
        com.baidu.ar.h.b.k(str, sb.toString());
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        if (hashMap != null) {
            this.bD = com.baidu.ar.arplay.c.c.a(hashMap.get("ability_name"), (String) null);
        }
        if (TextUtils.isEmpty(this.bD) || !"ability_anime".equals(this.bD)) {
            String str2 = TAG;
            com.baidu.ar.h.b.b(str2, "mAbilityName error: " + this.bD);
        }
        if (this.cd == null) {
            b bVar = new b(new b.InterfaceC0046b() { // from class: com.baidu.ar.anime.AnimeAR.1
                @Override // com.baidu.ar.anime.b.InterfaceC0046b
                public void a(int i, String str3, long j) {
                    if (i == 200) {
                        l r = AnimeAR.this.r();
                        if (r == null || j <= 0) {
                            return;
                        }
                        String str4 = AnimeAR.TAG;
                        com.baidu.ar.h.b.b(str4, "result setAlgoHandleData:" + j);
                        r.a(j, AnimeAR.this.bD);
                        AnimeAR.this.a(j);
                        return;
                    }
                    String str5 = AnimeAR.TAG;
                    com.baidu.ar.h.b.b(str5, "request error! code:" + i + " msg:" + str3);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("event_name", "anime_network_status");
                    hashMap2.put("error_code", Integer.valueOf(i));
                    hashMap2.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str3);
                    AnimeAR.this.d(hashMap2);
                }
            });
            this.cd = bVar;
            bVar.a(this.cb);
            this.cd.f(p.A(getContext()));
        }
        al();
        l r = r();
        if (r != null) {
            r.b(21, false);
        }
    }
}
