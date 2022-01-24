package c.a.t0.z3;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public SeekBar f26179b;

    /* renamed from: c  reason: collision with root package name */
    public View f26180c;

    /* renamed from: d  reason: collision with root package name */
    public int f26181d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f26182e;

    /* loaded from: classes9.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                c.a.t0.a3.p pVar = new c.a.t0.a3.p();
                pVar.a = 1;
                pVar.f15274b = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, pVar));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                seekBar.setProgressDrawable(SkinManager.getDrawable(n.video_navi_video_eight_width_seekbar));
                c.a.t0.a3.p pVar = new c.a.t0.a3.p();
                pVar.a = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, pVar));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                seekBar.setProgressDrawable(SkinManager.getDrawable(n.video_navi_video_eight_width_transparent_seekbar));
                c.a.t0.a3.p pVar = new c.a.t0.a3.p();
                pVar.a = 3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, pVar));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f26183e;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26183e = sVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f26183e.f26179b.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26183e.f26179b.getLayoutParams();
                if (layoutParams.bottomMargin != this.f26183e.f26181d) {
                    layoutParams.bottomMargin = this.f26183e.f26180c.getHeight() - c.a.d.f.p.n.f(this.f26183e.a, m.tbds16);
                    this.f26183e.f26179b.setLayoutParams(layoutParams);
                    this.f26183e.f26181d = layoutParams.bottomMargin;
                }
            }
        }
    }

    public s(BaseFragmentActivity baseFragmentActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26181d = -1;
        this.f26182e = new b(this);
        this.a = baseFragmentActivity;
        this.f26180c = view;
        SeekBar seekBar = (SeekBar) baseFragmentActivity.findViewById(o.video_seekbar);
        this.f26179b = seekBar;
        seekBar.setOnSeekBarChangeListener(new a(this));
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f26182e);
    }

    public SeekBar f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26179b : (SeekBar) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f26179b.setVisibility(z ? 0 : 4);
        }
    }
}
