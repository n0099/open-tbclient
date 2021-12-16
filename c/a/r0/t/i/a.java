package c.a.r0.t.i;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView;
import com.baidu.tbadk.coreExtra.view.FloorImageTextViewNew;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ImageViewerBottomLayout f13905b;

    /* renamed from: c  reason: collision with root package name */
    public AbsFloorImageTextView f13906c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f13907d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13908e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageViewerBottomLayout.a f13909f;

    /* renamed from: c.a.r0.t.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0859a implements ImageViewerBottomLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0859a(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, imageViewerBottomLayout, z) == null) {
                this.a.f13908e = z;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(this.a.f13908e)));
                this.a.q(z);
            }
        }
    }

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13908e = true;
        this.f13909f = new C0859a(this);
        this.a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f13907d = linearLayout;
        linearLayout.setOrientation(1);
        this.f13907d.setVisibility(8);
        SkinManager.setBackgroundColorToTransparent(this.f13907d, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.f13907d, layoutParams);
        d();
        e();
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageViewerBottomLayout imageViewerBottomLayout = this.f13905b;
            if (imageViewerBottomLayout == null || this.f13906c == null) {
                return 0;
            }
            return imageViewerBottomLayout.getHeight() + AbsFloorImageTextView.TEXT_SIZE;
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            FloorImageTextViewNew floorImageTextViewNew = new FloorImageTextViewNew(this.a);
            this.f13906c = floorImageTextViewNew;
            this.f13907d.addView(floorImageTextViewNew, layoutParams);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.ImageViewerBottomHeight);
            ImageViewerBottomLayout imageViewerBottomLayout = new ImageViewerBottomLayout(this.a);
            this.f13905b = imageViewerBottomLayout;
            this.f13907d.addView(imageViewerBottomLayout, layoutParams);
            this.f13905b.setExpandButtonListener(this.f13909f);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13908e : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(this.f13907d) : invokeV.booleanValue;
    }

    public final boolean h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) ? view != null && view.getVisibility() == 0 : invokeL.booleanValue;
    }

    public void i(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, imageUrlData) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.f13906c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.updateTextView(imageUrlData);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.f13905b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.updateData(imageUrlData);
            }
        }
    }

    public void j(ImageViewerBottomLayout.b bVar) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (imageViewerBottomLayout = this.f13905b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnDownloadImageListener(bVar);
    }

    public void k(View.OnClickListener onClickListener) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) || (imageViewerBottomLayout = this.f13905b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnReplyClickListener(onClickListener);
    }

    public void l(ImageViewerBottomLayout.c cVar) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || (imageViewerBottomLayout = this.f13905b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnShareImageListener(cVar);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.f13906c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.setUserId(str);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.f13905b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.setUserId(str);
            }
        }
    }

    public void n(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (linearLayout = this.f13907d) == null) {
            return;
        }
        linearLayout.clearAnimation();
        this.f13907d.setVisibility(i2);
    }

    public void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            if (i2 == 0) {
                c.a.s0.h4.b.c(this.f13907d, i3);
            } else {
                c.a.s0.h4.b.a(this.f13907d, i3);
            }
        }
    }

    public void p(boolean z) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (imageViewerBottomLayout = this.f13905b) == null) {
            return;
        }
        imageViewerBottomLayout.setYoungterCoverSomeView(z);
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.f13906c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.updateExpandState(z);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.f13905b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.updateUnfoldState(!z);
            }
        }
    }
}
