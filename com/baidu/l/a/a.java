package com.baidu.l.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.d;
import com.opensource.svgaplayer.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.swan.apps.component.a.d.a<SVGAImageView, b> {
    private d bay;

    public a(@Nullable Context context, @NonNull b bVar) {
        super(context, bVar);
        this.bay = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bm */
    public SVGAImageView bn(@NonNull Context context) {
        return new SVGAImageView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void ac(@NonNull final SVGAImageView sVGAImageView) {
        String str;
        FileInputStream fileInputStream;
        super.ac(sVGAImageView);
        if (this.bay == null) {
            this.bay = new d(sVGAImageView.getContext());
        }
        final b bVar = (b) KG();
        sVGAImageView.setLoops(bVar.loop ? 1 : 0);
        if (!TextUtils.isEmpty(bVar.path)) {
            if (bVar.path.startsWith("bdfile://")) {
                str = com.baidu.swan.apps.storage.b.bp(bVar.path, e.acD().id);
            } else {
                str = bVar.path;
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    fileInputStream = null;
                }
                this.bay.b(fileInputStream, str, new d.c() { // from class: com.baidu.l.a.a.1
                    @Override // com.opensource.svgaplayer.d.c
                    public void a(f fVar) {
                        sVGAImageView.setImageDrawable(new com.opensource.svgaplayer.b(fVar));
                        if (bVar.autoPlay) {
                            sVGAImageView.startAnimation();
                        }
                    }

                    @Override // com.opensource.svgaplayer.d.c
                    public void onError() {
                        if (a.DEBUG) {
                            Log.e("Component-SvgaView", "svga parse error");
                        }
                    }
                }, true);
            }
        }
        if (!bVar.loop) {
            b(sVGAImageView, bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    public void a(@NonNull SVGAImageView sVGAImageView, @NonNull b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        super.a((a) sVGAImageView, (SVGAImageView) bVar, bVar2);
        a(sVGAImageView, bVar);
    }

    private void a(@NonNull SVGAImageView sVGAImageView, @NonNull b bVar) {
        if (KK()) {
            if (DEBUG) {
                Log.d("Component-SvgaView", "renderAction");
            }
            String str = bVar.action;
            if (TextUtils.equals(str, AlaStaticKeys.ALA_STATIC_VALUE_PLAY)) {
                sVGAImageView.startAnimation();
            } else if (TextUtils.equals(str, "pause")) {
                sVGAImageView.pauseAnimation();
            } else if (TextUtils.equals(str, "stop")) {
                sVGAImageView.stopAnimation();
            }
        }
    }

    private void b(@NonNull SVGAImageView sVGAImageView, @NonNull final b bVar) {
        final JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("wvID", bVar.bil);
            jSONObject.put("vtype", "ended");
            jSONObject2.putOpt("animationViewId", bVar.bik);
            jSONObject.put("data", jSONObject2.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sVGAImageView.setCallback(new com.opensource.svgaplayer.a() { // from class: com.baidu.l.a.a.2
            @Override // com.opensource.svgaplayer.a
            public void onPause() {
            }

            @Override // com.opensource.svgaplayer.a
            public void onFinished() {
                if (!bVar.loop) {
                    com.baidu.swan.apps.view.b.b.a.a(bVar.bil, bVar.bik, "animateview", "ended", jSONObject);
                }
            }

            @Override // com.opensource.svgaplayer.a
            public void Gp() {
                c.d("Component-SvgaView", "onAnimationRepeat ");
            }

            @Override // com.opensource.svgaplayer.a
            public void b(int i, double d) {
            }
        });
    }
}
