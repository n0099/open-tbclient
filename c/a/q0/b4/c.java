package c.a.q0.b4;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f16095a;

    /* renamed from: b  reason: collision with root package name */
    public String f16096b;

    /* renamed from: c  reason: collision with root package name */
    public int f16097c;

    /* renamed from: d  reason: collision with root package name */
    public int f16098d;

    /* renamed from: e  reason: collision with root package name */
    public int f16099e;

    /* renamed from: f  reason: collision with root package name */
    public int f16100f;

    /* renamed from: g  reason: collision with root package name */
    public int f16101g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16102h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16103i;

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
        this.f16101g = -1;
        this.f16102h = false;
        this.f16103i = false;
    }

    public ArrayList<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16095a : (ArrayList) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16101g : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16096b : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16102h : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16103i : invokeV.booleanValue;
    }

    public SpannableStringBuilder f(Editable editable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, editable)) == null) {
            if (editable == null || StringUtils.isNull(editable.toString()) || ListUtils.isEmpty(this.f16095a)) {
                return null;
            }
            String obj = editable.toString();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
            boolean z = this.f16101g >= 0;
            this.f16101g = -1;
            Iterator<String> it = this.f16095a.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    m(spannableStringBuilder, obj, next);
                }
            }
            if (this.f16101g >= 0 || z) {
                ImageSpan[] imageSpanArr = (ImageSpan[]) editable.getSpans(0, obj.length(), ImageSpan.class);
                if (imageSpanArr != null) {
                    for (ImageSpan imageSpan : imageSpanArr) {
                        if (imageSpan != null) {
                            spannableStringBuilder.setSpan(imageSpan, editable.getSpanStart(imageSpan), editable.getSpanEnd(imageSpan), editable.getSpanFlags(imageSpan));
                        }
                    }
                }
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.f16097c;
            if (i2 != 0) {
                this.f16099e = SkinManager.getColor(i2);
            }
            int i3 = this.f16098d;
            if (i3 != 0) {
                this.f16100f = SkinManager.getColor(i3);
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f16098d = i2;
            this.f16100f = SkinManager.getColor(i2);
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.f16095a = arrayList;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f16097c = i2;
            this.f16099e = SkinManager.getColor(i2);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f16102h = z;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f16103i = z;
        }
    }

    public final void m(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, spannableStringBuilder, str, str2) == null) || spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f16099e == 0 && this.f16100f == 0) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        if (indexOf >= 0) {
            int i2 = this.f16101g;
            if (i2 == -1) {
                this.f16101g = indexOf + length;
            } else {
                int i3 = indexOf + length;
                if (i3 < i2) {
                    this.f16101g = i3;
                }
            }
        }
        while (indexOf >= 0) {
            if (this.f16099e != 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f16099e), indexOf, indexOf + length, 33);
            }
            if (this.f16100f != 0) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f16100f), indexOf, indexOf + length, 33);
            }
            indexOf = str.indexOf(str2, indexOf + 1);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f16096b = str;
        }
    }
}
