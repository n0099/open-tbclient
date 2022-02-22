package c.a.t0.b1.g;

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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public a f12616b;

    /* renamed from: c  reason: collision with root package name */
    public b f12617c;

    /* loaded from: classes6.dex */
    public static class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12618b;

        /* renamed from: c  reason: collision with root package name */
        public int f12619c;

        /* renamed from: d  reason: collision with root package name */
        public String f12620d;

        /* renamed from: e  reason: collision with root package name */
        public String f12621e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12622f;

        /* renamed from: g  reason: collision with root package name */
        public int f12623g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f12624h;

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
            this.f12618b = true;
            this.f12619c = R.drawable.new_pic_emotion_05;
            this.f12620d = h.c(R.string.no_data_common_txt, new Object[0]);
            this.f12621e = h.c(R.string.refresh_view_button_text, new Object[0]);
            this.f12622f = false;
            this.f12623g = n.f(h.getContext(), R.dimen.ds420);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12625b;

        /* renamed from: c  reason: collision with root package name */
        public int f12626c;

        /* renamed from: d  reason: collision with root package name */
        public int f12627d;

        /* renamed from: e  reason: collision with root package name */
        public String f12628e;

        /* renamed from: f  reason: collision with root package name */
        public String f12629f;

        /* renamed from: g  reason: collision with root package name */
        public String f12630g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f12631h;

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
            this.f12625b = true;
            this.f12626c = R.drawable.new_pic_emotion_08;
            this.f12627d = n.f(h.getContext(), R.dimen.ds280);
            this.f12628e = h.c(R.string.refresh_view_button_text, new Object[0]);
            this.f12629f = h.c(R.string.refresh_view_title_text, new Object[0]);
            this.f12630g = h.c(R.string.data_load_error, new Object[0]);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f12632b;

        /* renamed from: c  reason: collision with root package name */
        public String f12633c;

        /* renamed from: d  reason: collision with root package name */
        public String f12634d;

        /* renamed from: e  reason: collision with root package name */
        public String f12635e;

        /* renamed from: f  reason: collision with root package name */
        public String f12636f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f12637g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f12638h;

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
            this.f12632b = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f12633c = h.c(R.string.loading, new Object[0]);
            this.f12634d = h.c(R.string.pb_load_more, new Object[0]);
            this.f12635e = h.c(R.string.list_no_more, new Object[0]);
            this.f12636f = h.c(R.string.click_retry, new Object[0]);
            this.f12637g = false;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f12639b;

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

    /* loaded from: classes6.dex */
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
