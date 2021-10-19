package c.a.r0.u.a;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.t.c.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.view.SplashAdView;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f25020a;

    /* renamed from: b  reason: collision with root package name */
    public String f25021b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<SplashAdView> f25022c;

    /* renamed from: c.a.r0.u.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1157a implements CustomMessageTask.CustomRunnable<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25023e;

        public C1157a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25023e = aVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<m> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getCmd() == 2016310) {
                    try {
                        return new CustomResponsedMessage<>(2016310, this.f25023e.f(customMessage.getData()));
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.r0.u.a.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f25024a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f25025b;

        public b(a aVar, SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25025b = aVar;
            this.f25024a = splashAdView;
        }

        @Override // c.a.r0.u.a.g.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, str));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_ADVERTSDK_CLICK);
                statisticItem.param("obj_source", str);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.r0.u.a.g.a
        public void b(c.a.r0.u.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            }
        }

        @Override // c.a.r0.u.a.g.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.r0.u.a.g.a
        public void d() {
            c.a.r0.u.a.f.b entryInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SplashAdView splashAdView = (SplashAdView) this.f25025b.f25022c.get();
                if (splashAdView != null) {
                    this.f25025b.f25021b = this.f25024a.skipText();
                    a aVar = this.f25025b;
                    aVar.h(aVar.f25021b);
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_ADVERTSDK_SHOW);
                if (splashAdView != null && (entryInfoData = splashAdView.getEntryInfoData()) != null) {
                    if (entryInfoData.d()) {
                        statisticItem.param("obj_source", entryInfoData.f25084e);
                    } else {
                        statisticItem.param("obj_source", entryInfoData.f25081b);
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.r0.u.a.g.a
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements CountDownTextView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.d
        public void onTimeout(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f25026a;

        public /* synthetic */ e(CountDownTextView countDownTextView, C1157a c1157a) {
            this(countDownTextView);
        }

        public void a(String str) {
            CountDownTextView countDownTextView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (countDownTextView = this.f25026a.get()) == null) {
                return;
            }
            countDownTextView.init(str, 0);
        }

        public e(CountDownTextView countDownTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {countDownTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25026a = new WeakReference<>(countDownTextView);
        }
    }

    public a() {
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
        this.f25020a = null;
        this.f25021b = null;
    }

    public final View f(m mVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            if (mVar == null || !mVar.d()) {
                return null;
            }
            Activity pageActivity = mVar.c().getPageActivity();
            int a2 = mVar.a();
            int b2 = mVar.b();
            SplashAdView splashAdView = new SplashAdView(mVar.c(), "1481698145541", AdType.SPLASH, a2, b2, RedirectType.APPMANAGE);
            splashAdView.setLayoutParams(new RelativeLayout.LayoutParams(b2, a2));
            this.f25022c = new WeakReference<>(splashAdView);
            splashAdView.setBCAdCallBack(new b(this, splashAdView));
            try {
                z = splashAdView.isSplashAvailable();
            } catch (Throwable unused) {
                z = false;
            }
            if (z) {
                try {
                    int dimension = (int) pageActivity.getResources().getDimension(R.dimen.ds22);
                    int dimension2 = (int) pageActivity.getResources().getDimension(R.dimen.ds36);
                    Activity pageActivity2 = mVar.c().getPageActivity();
                    if (UtilHelper.isNotchScreen(pageActivity2) || UtilHelper.isCutoutScreen(pageActivity2)) {
                        dimension2 += l.r(pageActivity2);
                    }
                    int dimension3 = (int) pageActivity.getResources().getDimension(R.dimen.ds32);
                    int dimension4 = (int) pageActivity.getResources().getDimension(R.dimen.ds106);
                    int dimension5 = (int) pageActivity.getResources().getDimension(R.dimen.ds52);
                    CountDownTextView countDownTextView = new CountDownTextView(pageActivity);
                    this.f25020a = new e(countDownTextView, null);
                    String str = this.f25021b;
                    if (TextUtils.isEmpty(str)) {
                        str = pageActivity.getResources().getString(R.string.skip);
                    }
                    if (splashAdView.isVideoAd) {
                        countDownTextView.init(str, 6);
                    } else {
                        countDownTextView.init(str, 3);
                    }
                    splashAdView.setTag(Boolean.valueOf(splashAdView.isVideoAd));
                    float f2 = dimension;
                    countDownTextView.setTextSize(0, f2);
                    countDownTextView.setTextColor(Color.parseColor("#ffffff"));
                    countDownTextView.setGravity(17);
                    countDownTextView.setAlpha(0.5f);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor("#000000"));
                    gradientDrawable.setCornerRadius(pageActivity.getResources().getDimension(R.dimen.ds4));
                    gradientDrawable.setStroke(1, Color.parseColor("#000000"));
                    countDownTextView.setBackgroundDrawable(gradientDrawable);
                    countDownTextView.setOnClickListener(new c(this));
                    countDownTextView.setTimeoutListener(new d(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimension4, dimension5);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.setMargins(0, dimension2, dimension3, 0);
                    int g2 = l.g(pageActivity, R.dimen.ds9);
                    countDownTextView.setPadding(g2, g2, g2, g2);
                    splashAdView.addView(countDownTextView, layoutParams);
                    int dimension6 = (int) pageActivity.getResources().getDimension(R.dimen.ds28);
                    TextView textView = new TextView(pageActivity);
                    textView.setText(R.string.advert_label);
                    textView.setTextSize(0, f2);
                    textView.setAlpha(0.5f);
                    textView.setIncludeFontPadding(false);
                    textView.setGravity(17);
                    textView.setBackgroundDrawable(gradientDrawable.getConstantState().newDrawable());
                    int g3 = l.g(pageActivity, R.dimen.ds2);
                    textView.setPadding(g3, g3, g3, g3);
                    SkinManager.setViewTextColor(textView, R.color.common_color_10013);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) pageActivity.getResources().getDimension(R.dimen.ds68), (int) pageActivity.getResources().getDimension(R.dimen.ds40));
                    layoutParams2.setMargins(dimension6, 0, 0, dimension6);
                    layoutParams2.addRule(9);
                    layoutParams2.addRule(12);
                    splashAdView.addView(textView, layoutParams2);
                } catch (Exception unused2) {
                }
                return splashAdView;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016310, new C1157a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f25020a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25020a.a(str);
    }
}
