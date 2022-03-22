package c.a.p0.w1.l;

import android.text.TextUtils;
import android.view.ViewStub;
import c.a.d.f.p.n;
import c.a.o0.c1.g;
import c.a.o0.c1.o0;
import c.a.o0.r.e;
import c.a.p0.l3.o;
import c.a.p0.l3.z;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f19718f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f19719g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f19720b;

    /* renamed from: c  reason: collision with root package name */
    public o f19721c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.l3.f0.a f19722d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f19723e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1124343447, "Lc/a/p0/w1/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1124343447, "Lc/a/p0/w1/l/a;");
                return;
            }
        }
        f19718f = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        f19719g = n.k(TbadkApplication.getInst()) - (f19718f * 2);
    }

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.f19722d = (c.a.p0.l3.f0.a) z.q().k(IAdBaseAsyncController.Type.PIC_BANNER, null);
        } catch (ClassCastException e2) {
            if (e.e()) {
                throw new RuntimeException(e2);
            }
        }
        this.f19721c = this.f19722d.i(viewStub, tbPageContext);
    }

    public final g a(int i, boolean z, boolean z2, String str, int i2, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str, Integer.valueOf(i2), str2, str3, str4})) == null) {
            g gVar = new g();
            gVar.j = z;
            if (z) {
                return gVar;
            }
            gVar.f9942c = i;
            gVar.f9943d = z2 ? this.f19720b : this.a;
            MultiImageView multiImageView = this.f19723e;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f19723e.getCurrentUrlDragImageView().getImageView() != null) {
                float[] resizedSize = this.f19723e.getCurrentUrlDragImageView().getImageView().getResizedSize();
                if (resizedSize.length == 2) {
                    float f2 = resizedSize[0];
                    float f3 = resizedSize[1];
                    gVar.f9944e = f3;
                    if (f3 != 0.0f) {
                        gVar.f9945f = f2 / f3;
                    }
                }
                gVar.f9947h = n.f(TbadkApplication.getInst(), R.dimen.tbds130);
                ImageUrlData imageUrlData = this.f19723e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
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
                    gVar.f9947h += f19718f * Math.min(((Integer) o0.i(TbRichTextView.U(jSONArray, false).toString(), n.f(TbadkApplication.getInst(), R.dimen.tbds42), f19719g).second).intValue(), 3);
                }
                if (imageUrlData != null) {
                    gVar.k = imageUrlData.isBlockedPic;
                }
            }
            gVar.f9946g = str;
            gVar.i = i2;
            gVar.l = str2;
            gVar.m = str3;
            return gVar;
        }
        return (g) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19722d.onDestroy();
            this.f19721c.onDestroy();
        }
    }

    public void c(MultiImageView multiImageView, boolean z, int i, boolean z2, String str, int i2, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{multiImageView, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), str, Integer.valueOf(i2), str2, str3, str4}) == null) {
            this.f19723e = multiImageView;
            g a = a(i, z2, z, str, i2, str2, str3, str4);
            d(this.f19722d.d(a), a, z);
        }
    }

    public final void d(AdvertAppInfo advertAppInfo, g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, advertAppInfo, gVar, z) == null) {
            this.f19721c.a(advertAppInfo, gVar);
            if (advertAppInfo != null) {
                if (z) {
                    this.f19720b = Math.max(this.f19720b, gVar.f9942c);
                } else {
                    this.a = Math.max(this.a, gVar.f9942c);
                }
            }
        }
    }
}
