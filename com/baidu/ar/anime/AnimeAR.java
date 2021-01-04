package com.baidu.ar.anime;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class AnimeAR extends c {
    private static final String TAG = AnimeAR.class.getSimpleName();
    private LuaMsgListener cc;
    private String bD = null;
    private AlgoHandleController cb = null;
    private b cd = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FramePixels framePixels) {
        if (framePixels == null || this.cb == null) {
            return;
        }
        long createHandle = this.cb.createHandle();
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
        com.baidu.ar.h.b.b(TAG, "origin image setAlgoHandleData:" + createHandle);
        r.a(createHandle, this.bD);
        a(createHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final boolean z, final String str2) {
        final a aVar = new a();
        if (TextUtils.isEmpty(str2) && p.A(getContext())) {
            aVar.an();
        }
        aVar.a(new a.InterfaceC0065a() { // from class: com.baidu.ar.anime.AnimeAR.3
            @Override // com.baidu.ar.anime.a.InterfaceC0065a
            public void b(FramePixels framePixels) {
                AnimeAR.this.a(framePixels);
                if (z && AnimeAR.this.cd != null) {
                    com.baidu.ar.h.b.b(AnimeAR.TAG, "onFramePixelRead and mRequestController.request");
                    AnimeAR.this.cd.a(framePixels, str2);
                }
                new Thread(new Runnable() { // from class: com.baidu.ar.anime.AnimeAR.3.1
                    @Override // java.lang.Runnable
                    public void run() {
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
                    arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
                    return arrayList;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    String str = (String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME);
                    String str2 = (String) hashMap.get("type_name");
                    if ("get_pixel_frame".equals(str)) {
                        String str3 = (String) hashMap.get("filter_id");
                        String str4 = (String) hashMap.get("frame_type");
                        com.baidu.ar.h.b.aS("event_name: " + str + ", filterId: " + str3 + ", frameType:" + str4 + "type_name: " + str2);
                        AnimeAR.this.a(str3, "get_frame_only".equals(str4) ? false : "get_frame_and_request".equals(str4) ? true : true, str2);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.cb == null || this.cb.getHandleType(j) != 21) {
            return;
        }
        com.baidu.ar.h.b.b(TAG, "destroyHandle:" + j);
        this.cb.destroyHandle(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(this.cc);
        if (this.cd != null) {
            this.cd.release();
            this.cd = null;
        }
        if (this.cb != null) {
            this.cb.release();
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
        com.baidu.ar.h.b.k(TAG, "setup(luaParams):" + (hashMap != null ? hashMap.toString() : null));
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        if (hashMap != null) {
            this.bD = com.baidu.ar.arplay.c.c.a(hashMap.get("ability_name"), (String) null);
        }
        if (TextUtils.isEmpty(this.bD) || !"ability_anime".equals(this.bD)) {
            com.baidu.ar.h.b.b(TAG, "mAbilityName error: " + this.bD);
        }
        if (this.cd == null) {
            this.cd = new b(new b.InterfaceC0067b() { // from class: com.baidu.ar.anime.AnimeAR.1
                @Override // com.baidu.ar.anime.b.InterfaceC0067b
                public void a(int i, String str, long j) {
                    if (i != 200) {
                        com.baidu.ar.h.b.b(AnimeAR.TAG, "request error! code:" + i + " msg:" + str);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(LuaMessageHelper.KEY_EVENT_NAME, "anime_network_status");
                        hashMap2.put("error_code", Integer.valueOf(i));
                        hashMap2.put("error_msg", str);
                        AnimeAR.this.d(hashMap2);
                        return;
                    }
                    l r = AnimeAR.this.r();
                    if (r == null || j <= 0) {
                        return;
                    }
                    com.baidu.ar.h.b.b(AnimeAR.TAG, "result setAlgoHandleData:" + j);
                    r.a(j, AnimeAR.this.bD);
                    AnimeAR.this.a(j);
                }
            });
            this.cd.a(this.cb);
            this.cd.f(p.A(getContext()));
        }
        al();
        l r = r();
        if (r != null) {
            r.b(21, false);
        }
    }
}
