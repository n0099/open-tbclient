package com.baidu.live.business.view.tool;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedToolInfo;
import com.baidu.live.business.model.data.LiveFeedToolWrapData;
import com.baidu.live.business.view.search.LiveSearchGuideView;
import com.baidu.tieba.R;
import com.baidu.tieba.ce0;
import com.baidu.tieba.ge0;
import com.baidu.tieba.pb0;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveFeedPageToolFloatLayout extends RelativeLayout {
    public d a;
    public boolean b;
    public ObjectAnimator c;
    public View d;
    public ImageView e;
    public ViewGroup f;
    public LiveSearchGuideView g;

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, String str2);

        void b();

        void onItemShow(String str);

        void onSearchShowing(boolean z);
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ LiveFeedToolInfo a;

        public a(LiveFeedToolInfo liveFeedToolInfo) {
            this.a = liveFeedToolInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (LiveFeedPageToolFloatLayout.this.a != null) {
                d dVar = LiveFeedPageToolFloatLayout.this.a;
                LiveFeedToolInfo liveFeedToolInfo = this.a;
                dVar.a(liveFeedToolInfo.name, liveFeedToolInfo.cmd);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (LiveFeedPageToolFloatLayout.this.a != null) {
                LiveFeedPageToolFloatLayout.this.a.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (LiveFeedPageToolFloatLayout.this.a != null) {
                LiveFeedPageToolFloatLayout.this.a.b();
            }
        }
    }

    public LiveFeedPageToolFloatLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public void setCallback(d dVar) {
        this.a = dVar;
    }

    public void b(boolean z) {
        int alpha;
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.end();
        }
        if (z) {
            this.c = ObjectAnimator.ofFloat(this, Key.ALPHA, getAlpha(), 0.0f);
            alpha = (int) (getAlpha() * 200.0f);
        } else {
            this.c = ObjectAnimator.ofFloat(this, Key.ALPHA, getAlpha(), 1.0f);
            alpha = (int) ((1.0f - getAlpha()) * 200.0f);
        }
        this.c.setDuration(alpha);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.start();
    }

    public void setSearchGuideShowing(boolean z) {
        int i;
        LiveSearchGuideView liveSearchGuideView = this.g;
        if (liveSearchGuideView == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        liveSearchGuideView.setVisibility(i);
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (this.e.getVisibility() == 0) {
            layoutParams2.addRule(15);
        } else {
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f09155a);
            layoutParams2.bottomMargin = (int) TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics());
        }
        this.g.setLayoutParams(layoutParams2);
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05c7, (ViewGroup) this, true);
        this.d = findViewById(R.id.obfuscated_res_0x7f09155a);
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f09154f);
        this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09155b);
        this.g = (LiveSearchGuideView) findViewById(R.id.obfuscated_res_0x7f091550);
        this.e.setOnClickListener(new c());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics()));
        this.f.setBackgroundDrawable(gradientDrawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str) {
        char c2;
        String str2;
        LiveSearchGuideView liveSearchGuideView = this.g;
        if (liveSearchGuideView != null) {
            liveSearchGuideView.b(str, this.b);
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            ge0 f = ge0.f();
            if (this.b) {
                str2 = LiveFeedPageSdk.IMMERSION;
            } else {
                str2 = LiveFeedPageSdk.HOST_LIVE_TAB;
            }
            imageView.setImageResource(f.q(str2));
        }
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            Drawable background = viewGroup.getBackground();
            if (background instanceof GradientDrawable) {
                if (this.b) {
                    ((GradientDrawable) background).setColor(-10263190);
                } else {
                    int hashCode = str.hashCode();
                    if (hashCode != 99228) {
                        if (hashCode == 104817688 && str.equals("night")) {
                            c2 = 1;
                            if (c2 == 0) {
                                if (c2 == 1) {
                                    ((GradientDrawable) background).setColor(-15132391);
                                }
                            } else {
                                ((GradientDrawable) background).setColor(-1);
                            }
                        }
                        c2 = 65535;
                        if (c2 == 0) {
                        }
                    } else {
                        if (str.equals("day")) {
                            c2 = 0;
                            if (c2 == 0) {
                            }
                        }
                        c2 = 65535;
                        if (c2 == 0) {
                        }
                    }
                }
                this.f.setBackgroundDrawable(background);
            }
            for (int i = 0; i < this.f.getChildCount(); i++) {
                if (this.f.getChildAt(i) instanceof LiveFeedPageToolItemView) {
                    ((LiveFeedPageToolItemView) this.f.getChildAt(i)).b(str, this.b);
                }
            }
        }
    }

    public void e() {
        float f;
        Context context = getContext();
        if (this.b) {
            f = 38.0f;
        } else {
            f = 47.0f;
        }
        float b2 = pb0.b(context, f);
        ce0.f(this.e, b2, b2);
        this.g.c();
        if (this.f != null) {
            for (int i = 0; i < this.f.getChildCount(); i++) {
                if (this.f.getChildAt(i) instanceof LiveFeedPageToolItemView) {
                    ((LiveFeedPageToolItemView) this.f.getChildAt(i)).c();
                }
            }
        }
    }

    public void f() {
        this.a = null;
        ViewGroup viewGroup = this.f;
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            for (int i = 0; i < this.f.getChildCount(); i++) {
                if (this.f.getChildAt(i) instanceof LiveFeedPageToolItemView) {
                    ((LiveFeedPageToolItemView) this.f.getChildAt(i)).d();
                }
            }
        }
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void setData(LiveFeedToolWrapData liveFeedToolWrapData, LiveFeedConfig liveFeedConfig) {
        boolean z;
        ImageView imageView;
        boolean z2;
        if (liveFeedConfig != null) {
            z = liveFeedConfig.searchIsOpen;
        } else {
            z = false;
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        List<LiveFeedToolInfo> list = null;
        if (liveFeedToolWrapData != null) {
            list = liveFeedToolWrapData.infos;
        }
        if (list != null && !list.isEmpty()) {
            ViewGroup viewGroup = this.f;
            if (viewGroup == null) {
                return;
            }
            viewGroup.removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                LiveFeedToolInfo liveFeedToolInfo = list.get(i);
                LiveFeedPageToolItemView liveFeedPageToolItemView = new LiveFeedPageToolItemView(this.f.getContext());
                liveFeedPageToolItemView.setData(this.b, liveFeedToolInfo.icon, liveFeedToolInfo.name);
                liveFeedPageToolItemView.setOnClickListener(new a(liveFeedToolInfo));
                this.f.addView(liveFeedPageToolItemView, new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 57.0f, getResources().getDisplayMetrics())));
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onItemShow(liveFeedToolInfo.name);
                }
            }
            if (z) {
                LiveFeedPageToolItemView liveFeedPageToolItemView2 = new LiveFeedPageToolItemView(this.f.getContext());
                liveFeedPageToolItemView2.setData(this.b, R.drawable.obfuscated_res_0x7f080f0e, "搜索");
                liveFeedPageToolItemView2.setOnClickListener(new b());
                this.f.addView(liveFeedPageToolItemView2, new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 57.0f, getResources().getDisplayMetrics())));
            }
            int childCount = this.f.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.f.getChildAt(i2) instanceof LiveFeedPageToolItemView) {
                    LiveFeedPageToolItemView liveFeedPageToolItemView3 = (LiveFeedPageToolItemView) this.f.getChildAt(i2);
                    if (i2 != childCount - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    liveFeedPageToolItemView3.setDividerShowing(z2);
                }
            }
        } else if (z && (imageView = this.e) != null) {
            imageView.setVisibility(0);
        }
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.onSearchShowing(z);
        }
    }

    public void setImmersion(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        float f;
        float f2;
        float f3;
        this.b = z;
        View view2 = this.d;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                Context context = getContext();
                if (z) {
                    f3 = 15.0f;
                } else {
                    f3 = 10.0f;
                }
                layoutParams3.rightMargin = pb0.b(context, f3);
                this.d.setLayoutParams(layoutParams2);
            }
        }
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams4 = viewGroup.getLayoutParams();
            if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) layoutParams4;
                Context context2 = getContext();
                if (z) {
                    f2 = 0.0f;
                } else {
                    f2 = 4.0f;
                }
                layoutParams5.rightMargin = pb0.b(context2, f2);
                this.f.setLayoutParams(layoutParams4);
            }
        }
        ImageView imageView = this.e;
        if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
            Context context3 = getContext();
            if (z) {
                f = 38.0f;
            } else {
                f = 47.0f;
            }
            int b2 = pb0.b(context3, f);
            layoutParams.width = b2;
            layoutParams.height = b2;
            this.e.setLayoutParams(layoutParams);
        }
        d(ge0.f().r());
        e();
    }
}
