package c.a.q0.a1.g;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public a f12033b;

    /* renamed from: c  reason: collision with root package name */
    public b f12034c;

    /* loaded from: classes2.dex */
    public static class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12035b;

        /* renamed from: c  reason: collision with root package name */
        public int f12036c;

        /* renamed from: d  reason: collision with root package name */
        public String f12037d;

        /* renamed from: e  reason: collision with root package name */
        public String f12038e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12039f;

        /* renamed from: g  reason: collision with root package name */
        public int f12040g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f12041h;

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
            this.f12035b = true;
            this.f12036c = R.drawable.new_pic_emotion_05;
            this.f12037d = h.c(R.string.no_data_common_txt, new Object[0]);
            this.f12038e = h.c(R.string.refresh_view_button_text, new Object[0]);
            this.f12039f = false;
            this.f12040g = n.f(h.getContext(), R.dimen.ds420);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12042b;

        /* renamed from: c  reason: collision with root package name */
        public int f12043c;

        /* renamed from: d  reason: collision with root package name */
        public int f12044d;

        /* renamed from: e  reason: collision with root package name */
        public String f12045e;

        /* renamed from: f  reason: collision with root package name */
        public String f12046f;

        /* renamed from: g  reason: collision with root package name */
        public String f12047g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f12048h;

        public b() {
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
            this.f12042b = true;
            this.f12043c = R.drawable.new_pic_emotion_08;
            this.f12044d = n.f(h.getContext(), R.dimen.ds280);
            this.f12045e = h.c(R.string.refresh_view_button_text, new Object[0]);
            this.f12046f = h.c(R.string.refresh_view_title_text, new Object[0]);
            this.f12047g = h.c(R.string.data_load_error, new Object[0]);
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f12049b;

        /* renamed from: c  reason: collision with root package name */
        public String f12050c;

        /* renamed from: d  reason: collision with root package name */
        public String f12051d;

        /* renamed from: e  reason: collision with root package name */
        public String f12052e;

        /* renamed from: f  reason: collision with root package name */
        public String f12053f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f12054g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f12055h;

        public c() {
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
            this.a = n.f(h.getContext(), R.dimen.tbds182);
            this.f12049b = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f12050c = h.c(R.string.loading, new Object[0]);
            this.f12051d = h.c(R.string.pb_load_more, new Object[0]);
            this.f12052e = h.c(R.string.list_no_more, new Object[0]);
            this.f12053f = h.c(R.string.click_retry, new Object[0]);
            this.f12054g = false;
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f12056b;

        public d() {
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
            this.a = h.c(R.string.loading_text, new Object[0]);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String c(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, objArr)) == null) ? getContext().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? TbadkCoreApplication.getInst().getApplicationContext() : (Context) invokeV.objValue;
    }
}
