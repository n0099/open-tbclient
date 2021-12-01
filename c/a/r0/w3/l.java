package c.a.r0.w3;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import c.a.r0.x2.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public SeekBar f25268b;

    /* renamed from: c  reason: collision with root package name */
    public View f25269c;

    /* renamed from: d  reason: collision with root package name */
    public int f25270d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f25271e;

    /* loaded from: classes7.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
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
                m mVar = new m();
                mVar.a = 1;
                mVar.f25417b = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, mVar));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                seekBar.setProgressDrawable(SkinManager.getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
                m mVar = new m();
                mVar.a = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, mVar));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                seekBar.setProgressDrawable(SkinManager.getDrawable(R.drawable.video_navi_video_eight_width_transparent_seekbar));
                m mVar = new m();
                mVar.a = 3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, mVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f25272e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25272e = lVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f25272e.f25268b.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f25272e.f25268b.getLayoutParams();
                if (layoutParams.bottomMargin != this.f25272e.f25270d) {
                    layoutParams.bottomMargin = this.f25272e.f25269c.getHeight() - c.a.d.f.p.l.f(this.f25272e.a, R.dimen.tbds16);
                    this.f25272e.f25268b.setLayoutParams(layoutParams);
                    this.f25272e.f25270d = layoutParams.bottomMargin;
                }
            }
        }
    }

    public l(BaseFragmentActivity baseFragmentActivity, View view) {
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
        this.f25270d = -1;
        this.f25271e = new b(this);
        this.a = baseFragmentActivity;
        this.f25269c = view;
        SeekBar seekBar = (SeekBar) baseFragmentActivity.findViewById(R.id.video_seekbar);
        this.f25268b = seekBar;
        seekBar.setOnSeekBarChangeListener(new a(this));
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f25271e);
    }

    public SeekBar f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25268b : (SeekBar) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f25268b.setVisibility(z ? 0 : 4);
        }
    }
}
