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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class LivenessVideoGuidActivity extends LivenessBaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Button f38061a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f38062b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f38063c;

    /* renamed from: d  reason: collision with root package name */
    public View f38064d;

    /* renamed from: e  reason: collision with root package name */
    public View f38065e;

    /* renamed from: f  reason: collision with root package name */
    public LivenessRecogCallback f38066f;

    /* renamed from: g  reason: collision with root package name */
    public VideoGetPortraitModel f38067g;

    /* renamed from: h  reason: collision with root package name */
    public View f38068h;

    /* renamed from: i  reason: collision with root package name */
    public View f38069i;
    public ViewPager j;
    public List<View> k;
    public Handler l;
    public AtomicBoolean m;

    /* loaded from: classes7.dex */
    public class ViewPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LivenessVideoGuidActivity f38083a;

        /* renamed from: b  reason: collision with root package name */
        public List<View> f38084b;

        public ViewPagerAdapter(LivenessVideoGuidActivity livenessVideoGuidActivity, List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessVideoGuidActivity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38083a = livenessVideoGuidActivity;
            this.f38084b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
                viewGroup.removeView(this.f38084b.get(i2));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<View> list = this.f38084b;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                viewGroup.addView(this.f38084b.get(i2));
                return this.f38084b.get(i2);
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends Scroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LivenessVideoGuidActivity f38085a;

        /* renamed from: b  reason: collision with root package name */
        public int f38086b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LivenessVideoGuidActivity livenessVideoGuidActivity, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessVideoGuidActivity, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38085a = livenessVideoGuidActivity;
            this.f38086b = 300;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                super.startScroll(i2, i3, i4, i5, this.f38086b);
            }
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                super.startScroll(i2, i3, i4, i5, this.f38086b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LivenessVideoGuidActivity livenessVideoGuidActivity, Context context, Interpolator interpolator) {
            super(context, interpolator);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessVideoGuidActivity, context, interpolator};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (Interpolator) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f38085a = livenessVideoGuidActivity;
            this.f38086b = 300;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LivenessVideoGuidActivity livenessVideoGuidActivity, Context context, Interpolator interpolator, boolean z) {
            super(context, interpolator, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessVideoGuidActivity, context, interpolator, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (Interpolator) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f38085a = livenessVideoGuidActivity;
            this.f38086b = 300;
        }
    }

    public LivenessVideoGuidActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new AtomicBoolean(false);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1001 && i3 == 0) {
                finish();
            }
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onBackPressed();
            if (this.f38066f != null) {
                LivenessRecogResult livenessRecogResult = new LivenessRecogResult();
                livenessRecogResult.setResultMsg(com.baidu.fsg.face.base.c.a.ERROR_MSG_USER_CANCEL);
                livenessRecogResult.setResultCode(-204);
                this.f38066f.b(livenessRecogResult);
            }
            RimStatisticsUtil.onEvent(d.R);
            RimStatisticsUtil.getInstance().triggerSending();
        }
    }

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent().getExtras() != null && (serializable = getIntent().getExtras().getSerializable(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL)) != null && (serializable instanceof VideoGetPortraitModel)) {
                this.f38067g = (VideoGetPortraitModel) serializable;
            }
            setContentView(R.layout.layout_sapi_liveness_video_guide_page);
            d();
            a();
            this.l.postDelayed(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoGuidActivity f38070a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38070a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38070a.f38064d.post(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f38071a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38071a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.f38071a.f38070a.j.getCurrentItem() == 0) {
                                    this.f38071a.f38070a.m.set(true);
                                    this.f38071a.f38070a.j.setCurrentItem(1, true);
                                }
                            }
                        });
                    }
                }
            }, 3000L);
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(this.j, new a(this, this.j.getContext(), new LinearInterpolator()));
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f38069i.findViewById(R.id.rim_face_guide_video_page2);
            this.f38069i.findViewById(R.id.btn_start_photo).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoGuidActivity f38076a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38076a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RimStatisticsUtil.onEvent(d.M);
                        LogUtil.d("hello", "onEvent(StatServiceEvent.ENTERLIVENESS):  用户点击立即验证");
                        this.f38076a.e();
                    }
                }
            });
            linearLayout.post(new Runnable(this, linearLayout, (LinearLayout) this.f38069i.findViewById(R.id.rim_face_guide_indicator2_wrapper)) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LinearLayout f38077a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LinearLayout f38078b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoGuidActivity f38079c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, linearLayout, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38079c = this;
                    this.f38077a = linearLayout;
                    this.f38078b = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f38077a.getWidth(), (int) (this.f38077a.getHeight() * 0.68d));
                        layoutParams.gravity = 17;
                        this.f38078b.setLayoutParams(layoutParams);
                    }
                }
            });
            TextView textView = (TextView) this.f38069i.findViewById(R.id.rim_face_guide_indicator2_content);
            TextView textView2 = (TextView) this.f38069i.findViewById(R.id.rim_face_video_guide_indicator2_title_hint);
            VideoGetPortraitModel videoGetPortraitModel = this.f38067g;
            if (videoGetPortraitModel != null && !TextUtils.isEmpty(videoGetPortraitModel.guideContent)) {
                textView.setText(this.f38067g.guideContent);
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
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f38068h.findViewById(R.id.rim_face_guide_video_page1);
            linearLayout.post(new Runnable(this, linearLayout, (LinearLayout) this.f38068h.findViewById(R.id.rim_face_guide_indicator1_wrapper)) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LinearLayout f38080a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LinearLayout f38081b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoGuidActivity f38082c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, linearLayout, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38082c = this;
                    this.f38080a = linearLayout;
                    this.f38081b = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int width = this.f38080a.getWidth();
                        int height = (int) (this.f38080a.getHeight() * 0.68d);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
                        layoutParams.gravity = 17;
                        this.f38081b.setLayoutParams(layoutParams);
                        LivenessVideoGuidActivity livenessVideoGuidActivity = this.f38082c;
                        livenessVideoGuidActivity.a(width, height, livenessVideoGuidActivity.f38063c);
                    }
                }
            });
            TextView textView = (TextView) this.f38068h.findViewById(R.id.tv_name);
            ImageView imageView = (ImageView) this.f38068h.findViewById(R.id.guide_imageview);
            this.f38063c = imageView;
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.rim_face_loading_indicator1_bg));
            VideoGetPortraitModel videoGetPortraitModel = this.f38067g;
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
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f38066f = SapiLivenessRecogManager.getInstance().getLivenessRecogCallback();
            this.k = new ArrayList();
            this.f38068h = LayoutInflater.from(getActivity()).inflate(R.layout.rim_face_video_loading_indicator1, (ViewGroup) null);
            this.f38069i = LayoutInflater.from(getActivity()).inflate(R.layout.rim_face_video_loading_indicator2, (ViewGroup) null);
            this.k.add(this.f38068h);
            this.k.add(this.f38069i);
            this.l = new Handler();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            Intent intent = new Intent(this, LivenessVideoActivity.class);
            intent.putExtra(LivenessVideoLoadingActivity.KEY_VIDEOGETPORTRAITMODEL, this.f38067g);
            startActivityForResult(intent, 1001);
            System.gc();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            c();
            b();
            this.f38064d = findViewById(R.id.rim_face_guide_indicator_1);
            this.f38065e = findViewById(R.id.rim_face_guide_indicator_2);
            this.f38064d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoGuidActivity f38072a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38072a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f38072a.j.setCurrentItem(0);
                    }
                }
            });
            this.f38065e.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoGuidActivity f38073a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38073a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f38073a.j.setCurrentItem(1);
                    }
                }
            });
            ImageView imageView = (ImageView) findViewById(R.id.sapi_bio_title_btn_left);
            this.f38062b = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoGuidActivity f38074a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38074a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f38074a.onBackPressed();
                    }
                }
            });
            ViewPager viewPager = (ViewPager) findViewById(R.id.rim_face_video_guide_vp);
            this.j = viewPager;
            viewPager.setAdapter(new ViewPagerAdapter(this, this.k));
            this.j.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessVideoGuidActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoGuidActivity f38075a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38075a = this;
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                        if (this.f38075a.m.get()) {
                            RimStatisticsUtil.onEvent(d.K);
                            this.f38075a.m.set(false);
                        } else {
                            RimStatisticsUtil.onEvent(d.L);
                        }
                        if (i2 == 0) {
                            this.f38075a.f38064d.setBackgroundDrawable(this.f38075a.getResources().getDrawable(R.drawable.rim_face_indicator_circle_select));
                            this.f38075a.f38065e.setBackgroundDrawable(this.f38075a.getResources().getDrawable(R.drawable.rim_face_indicator_circle_normal));
                        } else if (i2 != 1) {
                        } else {
                            this.f38075a.f38064d.setBackgroundDrawable(this.f38075a.getResources().getDrawable(R.drawable.rim_face_indicator_circle_normal));
                            this.f38075a.f38065e.setBackgroundDrawable(this.f38075a.getResources().getDrawable(R.drawable.rim_face_indicator_circle_select));
                        }
                    }
                }
            });
            f.a(this, getResources().getColor(R.color.sapi_liveness_guide_bg_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65539, this, i2, i3, imageView) == null) {
            int i4 = (int) (i2 * 0.8d);
            int i5 = (int) (i3 * 0.8d);
            Drawable drawable = imageView.getDrawable();
            float f2 = i4;
            float f3 = i5;
            float f4 = f2 / f3;
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            float f5 = intrinsicWidth / intrinsicHeight;
            if (f4 > f5) {
                i4 = (int) (intrinsicWidth / (intrinsicHeight / f3));
            } else if (f4 < f5) {
                i5 = (int) (intrinsicHeight / (intrinsicWidth / f2));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i5);
            layoutParams.gravity = 1;
            imageView.setLayoutParams(layoutParams);
        }
    }
}
