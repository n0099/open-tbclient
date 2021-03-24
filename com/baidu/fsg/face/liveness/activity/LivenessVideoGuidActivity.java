package com.baidu.fsg.face.liveness.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.SapiLivenessRecogManager;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.d;
import com.baidu.fsg.face.liveness.datamodel.VideoGetPortraitModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.sapi2.biometrics.liveness.R;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class LivenessVideoGuidActivity extends LivenessBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public Button f5843a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f5844b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f5845c;

    /* renamed from: d  reason: collision with root package name */
    public View f5846d;

    /* renamed from: e  reason: collision with root package name */
    public View f5847e;

    /* renamed from: f  reason: collision with root package name */
    public LivenessRecogCallback f5848f;

    /* renamed from: g  reason: collision with root package name */
    public VideoGetPortraitModel f5849g;

    /* renamed from: h  reason: collision with root package name */
    public View f5850h;
    public View i;
    public ViewPager j;
    public List<View> k;
    public Handler l;
    public AtomicBoolean m = new AtomicBoolean(false);

    /* loaded from: classes2.dex */
    public class ViewPagerAdapter extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public List<View> f5865b;

        public ViewPagerAdapter(List<View> list) {
            this.f5865b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.f5865b.get(i));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<View> list = this.f5865b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView(this.f5865b.get(i));
            return this.f5865b.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes2.dex */
    public class a extends Scroller {

        /* renamed from: b  reason: collision with root package name */
        public int f5867b;

        public a(Context context) {
            super(context);
            this.f5867b = 300;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.f5867b);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.f5867b);
        }

        public a(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.f5867b = 300;
        }

        public a(Context context, Interpolator interpolator, boolean z) {
            super(context, interpolator, z);
            this.f5867b = 300;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == 0) {
            finish();
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.f5848f != null) {
            LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
            livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
            livenessRecogResult.setResultCode(-204);
            this.f5848f.b(livenessRecogResult);
        }
        RimStatisticsUtil.onEvent(d.R);
        RimStatisticsUtil.getInstance().triggerSending();
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        if (getIntent().getExtras() != null && (serializable = getIntent().getExtras().getSerializable(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL)) != null && (serializable instanceof VideoGetPortraitModel)) {
            this.f5849g = (VideoGetPortraitModel) serializable;
        }
        setContentView(R.layout.layout_sapi_liveness_video_guide_page);
        d();
        a();
        this.l.postDelayed(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.1
            @Override // java.lang.Runnable
            public void run() {
                LivenessVideoGuidActivity.this.f5846d.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LivenessVideoGuidActivity.this.j.getCurrentItem() == 0) {
                            LivenessVideoGuidActivity.this.m.set(true);
                            LivenessVideoGuidActivity.this.j.setCurrentItem(1, true);
                        }
                    }
                });
            }
        }, 3000L);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.j, new a(this.j.getContext(), new LinearInterpolator()));
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
        }
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
                int width = linearLayout.getWidth();
                double height = linearLayout.getHeight();
                Double.isNaN(height);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, (int) (height * 0.68d));
                layoutParams.gravity = 17;
                linearLayout2.setLayoutParams(layoutParams);
            }
        });
        TextView textView = (TextView) this.i.findViewById(R.id.rim_face_guide_indicator2_content);
        TextView textView2 = (TextView) this.i.findViewById(R.id.rim_face_video_guide_indicator2_title_hint);
        VideoGetPortraitModel videoGetPortraitModel = this.f5849g;
        if (videoGetPortraitModel != null && !TextUtils.isEmpty(videoGetPortraitModel.guideContent)) {
            textView.setText(this.f5849g.guideContent);
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
        final LinearLayout linearLayout = (LinearLayout) this.f5850h.findViewById(R.id.rim_face_guide_video_page1);
        final LinearLayout linearLayout2 = (LinearLayout) this.f5850h.findViewById(R.id.rim_face_guide_indicator1_wrapper);
        linearLayout.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.8
            @Override // java.lang.Runnable
            public void run() {
                int width = linearLayout.getWidth();
                double height = linearLayout.getHeight();
                Double.isNaN(height);
                int i = (int) (height * 0.68d);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, i);
                layoutParams.gravity = 17;
                linearLayout2.setLayoutParams(layoutParams);
                LivenessVideoGuidActivity livenessVideoGuidActivity = LivenessVideoGuidActivity.this;
                livenessVideoGuidActivity.a(width, i, livenessVideoGuidActivity.f5845c);
            }
        });
        TextView textView = (TextView) this.f5850h.findViewById(R.id.tv_name);
        ImageView imageView = (ImageView) this.f5850h.findViewById(R.id.guide_imageview);
        this.f5845c = imageView;
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.rim_face_loading_indicator1_bg));
        VideoGetPortraitModel videoGetPortraitModel = this.f5849g;
        String str = videoGetPortraitModel != null ? videoGetPortraitModel.display_name : "";
        LivenessRecogDTO livenessRecogDTO = this.livenessRecogDTO;
        if (livenessRecogDTO != null && livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO && !TextUtils.isEmpty(livenessRecogDTO.realName)) {
            str = this.livenessRecogDTO.realName;
        }
        if (TextUtils.isEmpty(str)) {
            textView.setText(String.format(getString(R.string.sapi_liveness_guide_photo_tip), ""));
            return;
        }
        String format = String.format(getString(R.string.sapi_liveness_guide_photo_tip), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.sapi_liveness_video_guide_tip_color));
        if (format.indexOf("*") > 0) {
            spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf("*"), format.indexOf("*") + str.length(), 33);
        } else {
            spannableStringBuilder.setSpan(foregroundColorSpan, format.indexOf(str), format.indexOf(str) + str.length(), 33);
        }
        textView.setText(spannableStringBuilder);
    }

    private void d() {
        this.f5848f = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
        this.k = new ArrayList();
        this.f5850h = LayoutInflater.from(getActivity()).inflate(R.layout.rim_face_video_loading_indicator1, (ViewGroup) null);
        this.i = LayoutInflater.from(getActivity()).inflate(R.layout.rim_face_video_loading_indicator2, (ViewGroup) null);
        this.k.add(this.f5850h);
        this.k.add(this.i);
        this.l = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent(this, LivenessVideoActivity.class);
        intent.putExtra(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL, this.f5849g);
        startActivityForResult(intent, 1001);
        System.gc();
    }

    private void a() {
        c();
        b();
        this.f5846d = findViewById(R.id.rim_face_guide_indicator_1);
        this.f5847e = findViewById(R.id.rim_face_guide_indicator_2);
        this.f5846d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoGuidActivity.this.j.setCurrentItem(0);
            }
        });
        this.f5847e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoGuidActivity.this.j.setCurrentItem(1);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.sapi_bio_title_btn_left);
        this.f5844b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessVideoGuidActivity.this.onBackPressed();
            }
        });
        ViewPager viewPager = (ViewPager) findViewById(R.id.rim_face_video_guide_vp);
        this.j = viewPager;
        viewPager.setAdapter(new ViewPagerAdapter(this.k));
        this.j.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f2, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (LivenessVideoGuidActivity.this.m.get()) {
                    RimStatisticsUtil.onEvent(d.K);
                    LivenessVideoGuidActivity.this.m.set(false);
                } else {
                    RimStatisticsUtil.onEvent(d.L);
                }
                if (i == 0) {
                    LivenessVideoGuidActivity.this.f5846d.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_select));
                    LivenessVideoGuidActivity.this.f5847e.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_normal));
                } else if (i != 1) {
                } else {
                    LivenessVideoGuidActivity.this.f5846d.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_normal));
                    LivenessVideoGuidActivity.this.f5847e.setBackgroundDrawable(LivenessVideoGuidActivity.this.getResources().getDrawable(R.drawable.rim_face_indicator_circle_select));
                }
            }
        });
        f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, ImageView imageView) {
        double d2 = i;
        Double.isNaN(d2);
        int i3 = (int) (d2 * 0.8d);
        double d3 = i2;
        Double.isNaN(d3);
        int i4 = (int) (d3 * 0.8d);
        Drawable drawable = imageView.getDrawable();
        float f2 = i3;
        float f3 = i4;
        float f4 = f2 / f3;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float f5 = intrinsicWidth / intrinsicHeight;
        if (f4 > f5) {
            i3 = (int) (intrinsicWidth / (intrinsicHeight / f3));
        } else if (f4 < f5) {
            i4 = (int) (intrinsicHeight / (intrinsicWidth / f2));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i4);
        layoutParams.gravity = 1;
        imageView.setLayoutParams(layoutParams);
    }
}
