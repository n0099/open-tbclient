package c.a.u0.v1.l;

import android.text.TextUtils;
import android.view.ViewStub;
import c.a.d.f.p.n;
import c.a.t0.d1.g;
import c.a.t0.d1.p0;
import c.a.t0.s.e;
import c.a.u0.l3.o;
import c.a.u0.l3.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f24863f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f24864g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f24865b;

    /* renamed from: c  reason: collision with root package name */
    public o f24866c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.u0.l3.e0.a f24867d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f24868e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1300552643, "Lc/a/u0/v1/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1300552643, "Lc/a/u0/v1/l/a;");
                return;
            }
        }
        f24863f = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        f24864g = n.k(TbadkApplication.getInst()) - (f24863f * 2);
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
            this.f24867d = (c.a.u0.l3.e0.a) y.q().k(IAdBaseAsyncController.Type.PIC_BANNER, null);
        } catch (ClassCastException e2) {
            if (e.e()) {
                throw new RuntimeException(e2);
            }
        }
        this.f24866c = this.f24867d.h(viewStub, tbPageContext);
    }

    public final g a(int i2, boolean z, boolean z2, String str, int i3, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4})) == null) {
            g gVar = new g();
            gVar.f12768j = z;
            if (z) {
                return gVar;
            }
            gVar.f12761c = i2;
            gVar.f12762d = z2 ? this.f24865b : this.a;
            MultiImageView multiImageView = this.f24868e;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f24868e.getCurrentUrlDragImageView().getImageView() != null) {
                float[] resizedSize = this.f24868e.getCurrentUrlDragImageView().getImageView().getResizedSize();
                if (resizedSize.length == 2) {
                    float f2 = resizedSize[0];
                    float f3 = resizedSize[1];
                    gVar.f12763e = f3;
                    if (f3 != 0.0f) {
                        gVar.f12764f = f2 / f3;
                    }
                }
                gVar.f12766h = n.f(TbadkApplication.getInst(), R.dimen.tbds130);
                ImageUrlData imageUrlData = this.f24868e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
                JSONArray jSONArray = null;
                if (imageUrlData != null) {
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (JSONException e2) {
                        if (e.e()) {
                            throw new RuntimeException(e2);
                        }
                    }
                }
                if (jSONArray != null) {
                    gVar.f12766h += f24863f * Math.min(((Integer) p0.i(TbRichTextView.parse(jSONArray, false).toString(), n.f(TbadkApplication.getInst(), R.dimen.tbds42), f24864g).second).intValue(), 3);
                }
                if (imageUrlData != null) {
                    gVar.k = imageUrlData.isBlockedPic;
                }
            }
            gVar.f12765g = str;
            gVar.f12767i = i3;
            gVar.l = str2;
            gVar.m = str3;
            return gVar;
        }
        return (g) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24867d.onDestroy();
            this.f24866c.onDestroy();
        }
    }

    public void c(MultiImageView multiImageView, boolean z, int i2, boolean z2, String str, int i3, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{multiImageView, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            this.f24868e = multiImageView;
            g a = a(i2, z2, z, str, i3, str2, str3, str4);
            d(this.f24867d.c(a), a, z);
        }
    }

    public final void d(AdvertAppInfo advertAppInfo, g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, advertAppInfo, gVar, z) == null) {
            this.f24866c.a(advertAppInfo, gVar);
            if (advertAppInfo != null) {
                if (z) {
                    this.f24865b = Math.max(this.f24865b, gVar.f12761c);
                } else {
                    this.a = Math.max(this.a, gVar.f12761c);
                }
            }
        }
    }
}
