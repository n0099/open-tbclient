package com.baidu.ar.anime;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.anime.a;
import com.baidu.ar.anime.b;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arrender.k;
import com.baidu.ar.c;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.g.e;
import com.baidu.ar.g.j;
import com.baidu.ar.g.p;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class AnimeAR extends c {
    private static final String TAG = AnimeAR.class.getSimpleName();
    private LuaMsgListener bZ;
    private String bA = null;
    private AlgoHandleController bY = null;
    private b ca = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FramePixels framePixels) {
        if (framePixels == null || this.bY == null) {
            return;
        }
        long createHandle = this.bY.createHandle();
        this.bY.setHandleInput(createHandle, 21, framePixels.getTimestamp(), 4, framePixels.getWidth(), framePixels.getHeight(), framePixels.isFrontCamera(), framePixels.getSegOrientation().getValue(), false, null);
        byte[] pixelData = framePixels.getPixelData();
        ReserveHandleData reserveHandleData = new ReserveHandleData();
        reserveHandleData.setByteDataSize(1);
        reserveHandleData.setByteWidths(new int[]{framePixels.getWidth()});
        reserveHandleData.setByteHeights(new int[]{framePixels.getHeight()});
        if (p.z(getContext())) {
            pixelData = j.c(e.a(j.a(framePixels.getWidth(), framePixels.getHeight(), pixelData), -90));
            reserveHandleData.setByteWidths(new int[]{framePixels.getHeight()});
            reserveHandleData.setByteHeights(new int[]{framePixels.getWidth()});
        }
        reserveHandleData.setByteFormats(new int[]{2});
        ArrayList arrayList = new ArrayList();
        arrayList.add(pixelData);
        reserveHandleData.setByteArrayListData(arrayList);
        AlgoHandleAdapter.setHandleReserveData(createHandle, reserveHandleData);
        k r = r();
        if (r == null || createHandle <= 0) {
            return;
        }
        com.baidu.ar.g.b.b(TAG, "origin image setAlgoHandleData:" + createHandle);
        r.a(createHandle, this.bA);
        a(createHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final boolean z) {
        final a aVar = new a();
        if (p.z(getContext())) {
            aVar.al();
        }
        aVar.a(new a.InterfaceC0069a() { // from class: com.baidu.ar.anime.AnimeAR.3
            @Override // com.baidu.ar.anime.a.InterfaceC0069a
            public void b(FramePixels framePixels) {
                AnimeAR.this.a(framePixels);
                if (z && AnimeAR.this.ca != null) {
                    com.baidu.ar.g.b.b(AnimeAR.TAG, "onFramePixelRead and mRequestController.request");
                    AnimeAR.this.ca.d(framePixels);
                }
                new Thread(new Runnable() { // from class: com.baidu.ar.anime.AnimeAR.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnimeAR.this.a(aVar);
                    }
                }).start();
            }
        });
        aVar.t(str);
        a(aVar, new com.baidu.ar.d.e() { // from class: com.baidu.ar.anime.AnimeAR.4
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        });
    }

    private void aj() {
        if (this.bZ == null) {
            this.bZ = new LuaMsgListener() { // from class: com.baidu.ar.anime.AnimeAR.2
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
                    return arrayList;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    String str = (String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME);
                    if ("get_pixel_frame".equals(str)) {
                        String str2 = (String) hashMap.get("filter_id");
                        String str3 = (String) hashMap.get("frame_type");
                        com.baidu.ar.g.b.aP("event_name: " + str + ", filterId: " + str2 + ", frameType:" + str3);
                        AnimeAR.this.a(str2, "get_frame_only".equals(str3) ? false : "get_frame_and_request".equals(str3) ? true : true);
                    }
                    if ("retry_anime_effect".equals(str)) {
                        com.baidu.ar.g.b.aP("event_name: " + str + " and mRequestController.retryChangeStyle()");
                        if (AnimeAR.this.ca != null) {
                            AnimeAR.this.ca.ap();
                        }
                    }
                    if ("cancel_anime_request".equals(str)) {
                        com.baidu.ar.g.b.aP("event_name: " + str + " and mRequestController.cancelAllRequest()");
                        if (AnimeAR.this.ca != null) {
                            AnimeAR.this.ca.aq();
                        }
                    }
                }
            };
        }
        a(this.bZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bY == null || this.bY.getHandleType(j) != 21) {
            return;
        }
        com.baidu.ar.g.b.b(TAG, "destroyHandle:" + j);
        this.bY.destroyHandle(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(this.bZ);
        if (this.ca != null) {
            this.ca.release();
            this.ca = null;
        }
        if (this.bY != null) {
            this.bY.release();
            this.bY = null;
        }
        k r = r();
        if (r != null) {
            r.o(21);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        com.baidu.ar.g.b.k(TAG, "setup(luaParams):" + (hashMap != null ? hashMap.toString() : null));
        if (this.bY == null) {
            this.bY = new AlgoHandleController();
        }
        if (hashMap != null) {
            this.bA = com.baidu.ar.arplay.c.c.a(hashMap.get("ability_name"), (String) null);
        }
        if (TextUtils.isEmpty(this.bA) || !"ability_anime".equals(this.bA)) {
            com.baidu.ar.g.b.b(TAG, "mAbilityName error: " + this.bA);
        }
        if (this.ca == null) {
            this.ca = new b(new b.InterfaceC0071b() { // from class: com.baidu.ar.anime.AnimeAR.1
                @Override // com.baidu.ar.anime.b.InterfaceC0071b
                public void a(int i, String str, long j) {
                    if (i != 200) {
                        com.baidu.ar.g.b.b(AnimeAR.TAG, "request error! code:" + i + " msg:" + str);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(LuaMessageHelper.KEY_EVENT_NAME, "anime_network_status");
                        hashMap2.put("error_code", Integer.valueOf(i));
                        hashMap2.put("error_msg", str);
                        AnimeAR.this.d(hashMap2);
                        return;
                    }
                    k r = AnimeAR.this.r();
                    if (r == null || j <= 0) {
                        return;
                    }
                    com.baidu.ar.g.b.b(AnimeAR.TAG, "result setAlgoHandleData:" + j);
                    r.a(j, AnimeAR.this.bA);
                    AnimeAR.this.a(j);
                }
            });
            this.ca.a(this.bY);
            this.ca.f(p.z(getContext()));
        }
        aj();
        k r = r();
        if (r != null) {
            r.b(21, false);
        }
    }
}
