package c.a.r0.a0.l.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a extends c.a.r0.g0.b<c.a.r0.a0.l.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public TextView n;
    public TextView o;
    public HeadImageView p;
    public HeadImageView q;
    public HeadImageView r;
    public ImageView s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        q(j());
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_person_center_list_normal_item : invokeV.intValue;
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (i2 == 1) {
                this.s.setAlpha(0.7f);
            } else {
                this.s.setAlpha(1);
            }
            this.m.setBackgroundColor(SkinManager.getColor(i2, R.color.CAM_X0204));
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public TextView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.o;
            if (textView != null) {
                return textView;
            }
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.m = view.findViewById(R.id.ala_person_center_list_item_sep);
            this.n = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
            this.o = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
            this.s = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
            this.p = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
            this.q = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
            this.r = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: s */
    public void k(c.a.r0.a0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
        }
    }

    public void t(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (textView = this.o) == null) {
            return;
        }
        textView.setText(str);
    }

    public void u(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (imageView = this.s) == null) {
            return;
        }
        imageView.setVisibility(i2);
    }

    public void v(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (view = this.m) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void w(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (textView = this.n) == null) {
            return;
        }
        textView.setText(str);
    }
}
