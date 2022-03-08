package c.a.b0.v.l0.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.b0.v.c0.p;
import c.a.b0.v.j0.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public AdImageView f2174i;

    /* renamed from: j  reason: collision with root package name */
    public AdImageView f2175j;

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
            }
        }
    }

    @Override // c.a.b0.v.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AdImageView adImageView = new AdImageView(this.f2135g);
            this.f2174i = adImageView;
            adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f2174i.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
            AdImageView adImageView2 = new AdImageView(this.f2135g);
            this.f2175j = adImageView2;
            adImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f2175j.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
            this.f2174i.setVisibility(8);
            this.f2175j.setVisibility(8);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f2175j.setVisibility(i2);
            this.f2174i.setVisibility(i2);
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.f2174i.getVisibility() == 8) {
            this.f2174i.setVisibility(0);
            this.f2174i.displayImage(str);
        }
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void d(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(pVar.c())) {
                int intValue = ((Integer) pVar.f(1)).intValue();
                if (intValue == 904 || 956 == intValue) {
                    this.f2174i.setVisibility(8);
                    this.f2175j.setVisibility(8);
                }
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(pVar.c())) {
                this.f2174i.setVisibility(8);
                this.f2175j.setVisibility(8);
            } else if ((!PlayerEvent.ACTION_SET_DATA_SOURCE.equals(pVar.c()) && !PlayerEvent.ACTION_PLAYER_ATTACH.equals(pVar.c())) || u() == null || u().o1() == null) {
            } else {
                L(u().o1().getPoster());
            }
        }
    }

    @Override // c.a.b0.v.j0.o
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2174i : (View) invokeV.objValue;
    }

    @Override // c.a.b0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new int[]{4, 2} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void q(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            if (ControlEvent.ACTION_RESUME.equals(pVar.c()) || ControlEvent.ACTION_SHOW_TIP.equals(pVar.c())) {
                this.f2174i.setVisibility(8);
                this.f2175j.setVisibility(8);
            }
        }
    }
}
