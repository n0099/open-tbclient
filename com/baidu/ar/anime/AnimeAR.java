package com.baidu.ar.anime;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.anime.a;
import com.baidu.ar.anime.b;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arrender.j;
import com.baidu.ar.c;
import com.baidu.ar.c.e;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class AnimeAR extends c {
    private static final String TAG = AnimeAR.class.getSimpleName();
    private LuaMsgListener bV;
    private String bx = null;
    private AlgoHandleController bU = null;
    private b bW = null;

    private void V() {
        if (this.bV == null) {
            this.bV = new LuaMsgListener() { // from class: com.baidu.ar.anime.AnimeAR.2
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
                        com.baidu.ar.f.b.aK("event_name: " + str + ", filterId: " + str2 + ", frameType:" + str3);
                        AnimeAR.this.a(str2, "get_frame_only".equals(str3) ? false : "get_frame_and_request".equals(str3) ? true : true);
                    }
                    if ("retry_anime_effect".equals(str)) {
                        com.baidu.ar.f.b.aK("event_name: " + str + " and mRequestController.retryChangeStyle()");
                        if (AnimeAR.this.bW != null) {
                            AnimeAR.this.bW.aa();
                        }
                    }
                    if ("cancel_anime_request".equals(str)) {
                        com.baidu.ar.f.b.aK("event_name: " + str + " and mRequestController.cancelAllRequest()");
                        if (AnimeAR.this.bW != null) {
                            AnimeAR.this.bW.ab();
                        }
                    }
                }
            };
        }
        a(this.bV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FramePixels framePixels) {
        if (framePixels == null || this.bU == null) {
            return;
        }
        long createHandle = this.bU.createHandle();
        this.bU.setHandleInput(createHandle, 21, framePixels.getTimestamp(), 4, framePixels.getWidth(), framePixels.getHeight(), framePixels.isFrontCamera(), framePixels.getSegOrientation().getValue(), false, null);
        byte[] pixelData = framePixels.getPixelData();
        ReserveHandleData reserveHandleData = new ReserveHandleData();
        reserveHandleData.setByteDataSize(1);
        reserveHandleData.setByteWidths(new int[]{framePixels.getWidth()});
        reserveHandleData.setByteHeights(new int[]{framePixels.getHeight()});
        reserveHandleData.setByteFormats(new int[]{2});
        ArrayList arrayList = new ArrayList();
        arrayList.add(pixelData);
        reserveHandleData.setByteArrayListData(arrayList);
        AlgoHandleAdapter.setHandleReserveData(createHandle, reserveHandleData);
        j r = r();
        if (r == null || createHandle <= 0) {
            return;
        }
        com.baidu.ar.f.b.b(TAG, "origin image setAlgoHandleData:" + createHandle);
        r.a(createHandle, this.bx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final boolean z) {
        final a aVar = new a();
        aVar.a(new a.InterfaceC0071a() { // from class: com.baidu.ar.anime.AnimeAR.3
            @Override // com.baidu.ar.anime.a.InterfaceC0071a
            public void b(FramePixels framePixels) {
                AnimeAR.this.a(framePixels);
                if (z && AnimeAR.this.bW != null) {
                    com.baidu.ar.f.b.b(AnimeAR.TAG, "onFramePixelRead and mRequestController.request");
                    AnimeAR.this.bW.d(framePixels);
                }
                new Thread(new Runnable() { // from class: com.baidu.ar.anime.AnimeAR.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnimeAR.this.a(aVar);
                    }
                }).start();
            }
        });
        aVar.s(str);
        a(aVar, new e() { // from class: com.baidu.ar.anime.AnimeAR.4
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bU == null || this.bU.getHandleType(j) != 21) {
            return;
        }
        com.baidu.ar.f.b.b(TAG, "destroyHandle:" + j);
        this.bU.destroyHandle(j);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(this.bV);
        if (this.bW != null) {
            this.bW.release();
            this.bW = null;
        }
        if (this.bU != null) {
            this.bU.release();
            this.bU = null;
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        com.baidu.ar.f.b.i(TAG, "setup(luaParams):" + (hashMap != null ? hashMap.toString() : null));
        if (this.bU == null) {
            this.bU = new AlgoHandleController();
        }
        if (hashMap != null) {
            this.bx = com.baidu.ar.arplay.c.c.a(hashMap.get("ability_name"), (String) null);
        }
        if (TextUtils.isEmpty(this.bx) || !"ability_anime".equals(this.bx)) {
            com.baidu.ar.f.b.b(TAG, "mAbilityName error: " + this.bx);
        }
        if (this.bW == null) {
            this.bW = new b(new b.InterfaceC0073b() { // from class: com.baidu.ar.anime.AnimeAR.1
                @Override // com.baidu.ar.anime.b.InterfaceC0073b
                public void a(int i, String str, long j) {
                    if (i == 200) {
                        j r = AnimeAR.this.r();
                        if (r == null || j <= 0) {
                            return;
                        }
                        com.baidu.ar.f.b.b(AnimeAR.TAG, "result setAlgoHandleData:" + j);
                        r.a(j, AnimeAR.this.bx);
                        return;
                    }
                    com.baidu.ar.f.b.b(AnimeAR.TAG, "request error! code:" + i + " msg:" + str);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(LuaMessageHelper.KEY_EVENT_NAME, "anime_network_status");
                    hashMap2.put("error_code", Integer.valueOf(i));
                    hashMap2.put("error_msg", str);
                    AnimeAR.this.d(hashMap2);
                }
            });
            this.bW.a(this.bU);
        }
        V();
    }
}
