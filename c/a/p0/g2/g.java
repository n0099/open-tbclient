package c.a.p0.g2;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public TableLayout f15156b;

    /* renamed from: c  reason: collision with root package name */
    public View f15157c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15158d;

    /* renamed from: e  reason: collision with root package name */
    public View f15159e;

    public g(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public View a(c cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, cVar, i)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d075b, (ViewGroup) null);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f4c);
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e7f);
            if (cVar != null) {
                int c2 = cVar.c();
                imageView.setVisibility(0);
                imageView.setTag(Integer.valueOf(c2));
                g(imageView, c2, TbadkCoreApplication.getInst().getSkinType());
                textView.setText(e(cVar.b(), 8));
                linearLayout.setTag(cVar);
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f0859);
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
                imageView.setVisibility(8);
            }
            b(linearLayout, i, this.f15156b, 2);
            return linearLayout;
        }
        return (View) invokeLI.objValue;
    }

    public final void b(View view, int i, TableLayout tableLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Integer.valueOf(i), tableLayout, Integer.valueOf(i2)}) == null) {
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a3), -2);
            if (i % i2 == 0) {
                TableRow tableRow = new TableRow(this.a.getPageActivity());
                tableRow.addView(view, layoutParams);
                tableLayout.addView(tableRow);
            } else if (tableLayout.getChildCount() != 0) {
                ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15156b.removeAllViews();
            this.f15157c.setVisibility(8);
            this.f15156b.setVisibility(8);
            this.f15158d.setVisibility(8);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d075a, (ViewGroup) null);
            this.f15157c = inflate;
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f092031);
            this.f15159e = findViewById;
            findViewById.setVisibility(0);
            this.f15156b = (TableLayout) this.f15157c.findViewById(R.id.obfuscated_res_0x7f091c4c);
            TextView textView = (TextView) this.f15157c.findViewById(R.id.obfuscated_res_0x7f091d84);
            this.f15158d = textView;
            textView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0884));
            return this.f15157c;
        }
        return (View) invokeV.objValue;
    }

    public final String e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.length() <= i) {
                return str;
            }
            String substring = str.substring(0, i - 1);
            return substring + this.a.getString(R.string.obfuscated_res_0x7f0f0525);
        }
        return (String) invokeLI.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.getLayoutMode().j(this.f15157c);
            int childCount = this.f15156b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                TableRow tableRow = (TableRow) this.f15156b.getChildAt(i2);
                int childCount2 = tableRow.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                    if (linearLayout.getChildCount() != 0) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
                        } else {
                            g(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, i);
                        }
                        SkinManager.setBackgroundResource(textView, R.drawable.square_search_item_bg, i);
                    }
                }
            }
        }
    }

    public final void g(ImageView imageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048582, this, imageView, i, i2) == null) || imageView == null) {
            return;
        }
        imageView.setImageDrawable(null);
        if (i == 1) {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_new, i2);
        } else if (i == 2) {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_hot, i2);
        } else if (i != 3) {
            imageView.setVisibility(8);
        } else {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_recommend, i2);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.f15158d == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f15158d.setText(str);
        } else {
            this.f15158d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0884));
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f15159e.setVisibility(z ? 0 : 8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            f(TbadkCoreApplication.getInst().getSkinType());
            this.f15157c.setVisibility(0);
            this.f15156b.setVisibility(0);
            this.f15158d.setVisibility(0);
        }
    }
}
