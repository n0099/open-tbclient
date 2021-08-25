package c.a.q0.l1.k;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewStub;
import c.a.e.e.p.l;
import c.a.p0.b1.c;
import c.a.p0.b1.l0;
import c.a.q0.x2.o;
import c.a.q0.x2.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f21713f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f21714g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f21715a;

    /* renamed from: b  reason: collision with root package name */
    public int f21716b;

    /* renamed from: c  reason: collision with root package name */
    public o f21717c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.x2.e0.a f21718d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f21719e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1801474654, "Lc/a/q0/l1/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1801474654, "Lc/a/q0/l1/k/a;");
                return;
            }
        }
        f21713f = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        f21714g = l.k(TbadkApplication.getInst()) - (f21713f * 2);
    }

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.f21718d = (c.a.q0.x2.e0.a) y.o().k(IAdBaseAsyncController.Type.PIC_BANNER, null);
        } catch (ClassCastException unused) {
        }
        this.f21717c = this.f21718d.i(viewStub, tbPageContext);
    }

    public final c a(int i2, boolean z, boolean z2, String str, int i3, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4})) == null) {
            c cVar = new c();
            cVar.f12830j = z;
            if (z) {
                return cVar;
            }
            cVar.f12823c = i2;
            cVar.f12824d = z2 ? this.f21716b : this.f21715a;
            MultiImageView multiImageView = this.f21719e;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f21719e.getCurrentUrlDragImageView().getImageView() != null) {
                float[] resizedSize = this.f21719e.getCurrentUrlDragImageView().getImageView().getResizedSize();
                if (resizedSize.length == 2) {
                    float f2 = resizedSize[0];
                    float f3 = resizedSize[1];
                    cVar.f12825e = f3;
                    if (f3 != 0.0f) {
                        cVar.f12826f = f2 / f3;
                    }
                }
                cVar.f12828h = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
                ImageUrlData imageUrlData = this.f21719e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
                JSONArray jSONArray = null;
                if (imageUrlData != null) {
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (jSONArray != null) {
                    cVar.f12828h += f21713f * Math.min(((Integer) l0.i(TbRichTextView.parse((Context) TbadkCoreApplication.getInst(), jSONArray, false).toString(), l.g(TbadkApplication.getInst(), R.dimen.tbds42), f21714g).second).intValue(), 3);
                }
                if (imageUrlData != null) {
                    cVar.k = imageUrlData.isBlockedPic;
                }
            }
            cVar.f12827g = str;
            cVar.f12829i = i3;
            cVar.l = str2;
            cVar.m = str3;
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21718d.onDestroy();
            this.f21717c.onDestroy();
        }
    }

    public void c(MultiImageView multiImageView, boolean z, int i2, boolean z2, String str, int i3, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{multiImageView, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            this.f21719e = multiImageView;
            c a2 = a(i2, z2, z, str, i3, str2, str3, str4);
            d(this.f21718d.c(a2), a2, z);
        }
    }

    public final void d(AdvertAppInfo advertAppInfo, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, advertAppInfo, cVar, z) == null) {
            this.f21717c.a(advertAppInfo, cVar);
            if (advertAppInfo != null) {
                if (z) {
                    this.f21716b = Math.max(this.f21716b, cVar.f12823c);
                } else {
                    this.f21715a = Math.max(this.f21715a, cVar.f12823c);
                }
            }
        }
    }
}
