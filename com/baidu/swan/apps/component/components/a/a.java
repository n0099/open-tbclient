package com.baidu.swan.apps.component.components.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends com.baidu.swan.apps.component.a.d.a<LottieAnimationView, b> {
    @NonNull
    private String cbd;

    public a(@Nullable Context context, @NonNull b bVar, @NonNull String str) {
        super(context, bVar);
        this.cbd = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bG */
    public LottieAnimationView bf(@NonNull Context context) {
        return new LottieAnimationView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void af(@NonNull LottieAnimationView lottieAnimationView) {
        super.af(lottieAnimationView);
        try {
            b bVar = (b) adc();
            lottieAnimationView.loop(bVar.loop);
            lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
            lottieAnimationView.setAnimationFromJson(this.cbd, bVar.caX);
            if (bVar.autoPlay) {
                lottieAnimationView.playAnimation();
            }
            if (!bVar.loop) {
                d(lottieAnimationView, bVar);
            }
        } catch (Exception e) {
            aY(this.cbd, e.azK());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    public void a(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        super.a((a) lottieAnimationView, (LottieAnimationView) bVar, bVar2);
        c(lottieAnimationView, bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a
    public void a(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-AnimationView", "renderBackground");
        }
        lottieAnimationView.setColorFilter(new PorterDuffColorFilter(bVar.backgroundColor, PorterDuff.Mode.ADD));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a
    public void b(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar) {
    }

    private void c(@NonNull LottieAnimationView lottieAnimationView, @NonNull b bVar) {
        if (adg()) {
            if (DEBUG) {
                Log.d("Component-AnimationView", "renderAction");
            }
            String str = bVar.action;
            if (TextUtils.equals(str, AlaStaticKeys.ALA_STATIC_VALUE_PLAY)) {
                lottieAnimationView.resumeAnimation();
            } else if (TextUtils.equals(str, "pause")) {
                lottieAnimationView.pauseAnimation();
            } else if (TextUtils.equals(str, "stop")) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setProgress(0.0f);
            }
        }
    }

    private void d(@NonNull final LottieAnimationView lottieAnimationView, @NonNull final b bVar) {
        final JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("wvID", bVar.caY);
            jSONObject.put("vtype", "ended");
            jSONObject2.putOpt("animationViewId", bVar.caX);
            jSONObject.put("data", jSONObject2.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.component.components.a.a.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.swan.apps.view.b.b.a.a(bVar.caY, bVar.caX, "animateview", "ended", jSONObject);
                c.i("Component-AnimationView", "progress: " + lottieAnimationView.getProgress());
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                c.i("Component-AnimationView", "onAnimationRepeat ");
            }
        });
    }

    public static void aY(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("json", str);
            jSONObject.put("appId", str2);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (DEBUG && TextUtils.isEmpty(jSONObject2)) {
            Log.d("Component-AnimationView", "reportLottieAnimationCrash: empty");
            return;
        }
        if (DEBUG) {
            Log.d("Component-AnimationView", "reportLottieAnimationCrash: " + jSONObject2);
        }
        new c.a(10009).rk(jSONObject2).rj(e.azK()).ama();
    }
}
