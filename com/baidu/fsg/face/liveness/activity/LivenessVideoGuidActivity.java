package com.baidu.fsg.face.liveness.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.sapi2.biometrics.liveness.R;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes17.dex */
public class LivenessVideoGuidActivity extends LivenessBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private Button f1697a;
    private ImageView b;
    private ImageView c;
    private View d;
    private View e;
    private LivenessRecogCallback f;
    private VideoGetPortraitModel g;
    private View h;
    private View i;
    private ViewPager j;
    private List<View> k;
    private Handler l;
    private AtomicBoolean m = new AtomicBoolean(false);

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        if (getIntent().getExtras() != null && (serializable = getIntent().getExtras().getSerializable(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL)) != null && (serializable instanceof VideoGetPortraitModel)) {
            this.g = (VideoGetPortraitModel) serializable;
        }
        setContentView(R.layout.layout_sapi_liveness_video_guide_page);
        d();
        a();
        this.l.postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.1
            @Override // java.lang.Runnable
            public void run() {
                LivenessVideoGuidActivity.this.d.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LivenessVideoGuidActivity.this.j.getCurrentItem() == 0) {
                            LivenessVideoGuidActivity.this.m.set(true);
                            LivenessVideoGuidActivity.this.j.setCurrentItem(1, true);
                        }
                    }
                });
            }
        }, IMConnection.RETRY_DELAY_TIMES);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.j, new a(this.j.getContext(), new LinearInterpolator()));
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        } catch (NoSuchFieldException e3) {
        }
    }

    private void a() {
        c();
        b();
        this.d = findViewById(R.id.rim_face_guide_indicator_1);
        this.e = findViewById(R.id.rim_face_guide_indicator_2);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoGuidActivity.this.j.setCurrentItem(0);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoGuidActivity.this.j.setCurrentItem(1);
            }
        });
        this.b = (ImageView) findViewById(R.id.sapi_bio_title_btn_left);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoGuidActivity.this.onBackPressed();
            }
        });
        this.j = (ViewPager) findViewById(R.id.rim_face_video_guide_vp);
        this.j.setAdapter(new ViewPagerAdapter(this.k));
        this.j.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.5
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (LivenessVideoGuidActivity.this.m.get()) {
                    RimStatisticsUtil.onEvent(d.K);
                    LivenessVideoGuidActivity.this.m.set(false);
                } else {
                    RimStatisticsUtil.onEvent(d.L);
                }
                switch (i) {
                    case 0:
                        LivenessVideoGuidActivity.this.d.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_select));
                        LivenessVideoGuidActivity.this.e.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_normal));
                        return;
                    case 1:
                        LivenessVideoGuidActivity.this.d.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_normal));
                        LivenessVideoGuidActivity.this.e.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_select));
                        return;
                    default:
                        return;
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
    }

    private void b() {
        final LinearLayout linearLayout = (LinearLayout) this.i.findViewById(R.id.rim_face_guide_video_page2);
        final LinearLayout linearLayout2 = (LinearLayout) this.i.findViewById(R.id.rim_face_guide_indicator2_wrapper);
        this.i.findViewById(R.id.btn_start_photo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RimStatisticsUtil.onEvent(d.M);
                LogUtil.d("hello", "onEvent(StatServiceEvent.ENTERLIVENESS):  用户点击立即验证");
                LivenessVideoGuidActivity.this.e();
            }
        });
        linearLayout.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.7
            @Override // java.lang.Runnable
            public void run() {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(linearLayout.getWidth(), (int) (linearLayout.getHeight() * 0.68d));
                layoutParams.gravity = 17;
                linearLayout2.setLayoutParams(layoutParams);
            }
        });
        TextView textView = (TextView) this.i.findViewById(R.id.rim_face_guide_indicator2_content);
        TextView textView2 = (TextView) this.i.findViewById(R.id.rim_face_video_guide_indicator2_title_hint);
        if (this.g != null && !TextUtils.isEmpty(this.g.guideContent)) {
            textView.setText(this.g.guideContent);
        }
        String charSequence = textView2.getText().toString();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.sapi_liveness_video_guide_tip_color));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int indexOf = charSequence.indexOf("普");
        if (indexOf > 0) {
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, indexOf + 3, 33);
        }
        textView2.setText(spannableStringBuilder);
    }

    private void c() {
        final LinearLayout linearLayout = (LinearLayout) this.h.findViewById(R.id.rim_face_guide_video_page1);
        final LinearLayout linearLayout2 = (LinearLayout) this.h.findViewById(R.id.rim_face_guide_indicator1_wrapper);
        linearLayout.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.8
            @Override // java.lang.Runnable
            public void run() {
                int width = linearLayout.getWidth();
                int height = (int) (linearLayout.getHeight() * 0.68d);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                linearLayout2.setLayoutParams(layoutParams);
                LivenessVideoGuidActivity.this.a(width, height, LivenessVideoGuidActivity.this.c);
            }
        });
        TextView textView = (TextView) this.h.findViewById(R.id.tv_name);
        this.c = (ImageView) this.h.findViewById(R.id.guide_imageview);
        this.c.setImageDrawable(getResources().getDrawable(R.drawable.rim_face_loading_indicator1_bg));
        String str = "";
        if (this.g != null) {
            str = this.g.display_name;
        }
        if (this.livenessRecogDTO != null && this.livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO && !TextUtils.isEmpty(this.livenessRecogDTO.realName)) {
            str = this.livenessRecogDTO.realName;
        }
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(getString(R.string.sapi_liveness_guide_photo_tip), str);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.sapi_liveness_video_guide_tip_color));
            if (format.indexOf("*") > 0) {
                spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf("*"), str.length() + format.indexOf("*"), 33);
            } else {
                spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf(str), str.length() + format.indexOf(str), 33);
            }
            textView.setText(spannableStringBuilder);
            return;
        }
        textView.setText(String.format(getString(R.string.sapi_liveness_guide_photo_tip), ""));
    }

    private void d() {
        this.f = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        this.k = new ArrayList();
        this.h = LayoutInflater.from(getActivity()).inflate(R.layout.rim_face_video_loading_indicator1, (ViewGroup) null);
        this.i = LayoutInflater.from(getActivity()).inflate(R.layout.rim_face_video_loading_indicator2, (ViewGroup) null);
        this.k.add(this.h);
        this.k.add(this.i);
        this.l = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent(this, LivenessVideoActivity.class);
        intent.putExtra(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL, this.g);
        startActivityForResult(intent, 1001);
        System.gc();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == 0) {
            finish();
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.f != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultMsg(LivenessRecogResult.ERROR_MSG_USER_CANCEL);
            livenessRecogResult.setResultCode(-204);
            this.f.b(livenessRecogResult);
        }
        RimStatisticsUtil.onEvent(d.R);
        RimStatisticsUtil.getInstance().triggerSending();
    }

    /* loaded from: classes17.dex */
    public class ViewPagerAdapter extends PagerAdapter {
        private List<View> b;

        public ViewPagerAdapter(List<View> list) {
            this.b = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.b == null) {
                return 0;
            }
            return this.b.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView(this.b.get(i));
            return this.b.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.b.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, ImageView imageView) {
        int i3 = (int) (i * 0.8d);
        int i4 = (int) (i2 * 0.8d);
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float f = i3 / i4;
        float f2 = intrinsicWidth / intrinsicHeight;
        if (f > f2) {
            i3 = (int) (intrinsicWidth / (intrinsicHeight / i4));
        } else if (f < f2) {
            i4 = (int) (intrinsicHeight / (intrinsicWidth / i3));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i4);
        layoutParams.gravity = 1;
        imageView.setLayoutParams(layoutParams);
    }

    /* loaded from: classes17.dex */
    public class a extends Scroller {
        private int b;

        public a(Context context) {
            super(context);
            this.b = 300;
        }

        public a(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.b = 300;
        }

        public a(Context context, Interpolator interpolator, boolean z) {
            super(context, interpolator, z);
            this.b = 300;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.b);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.b);
        }
    }
}
