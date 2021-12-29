package c.a.t0.u1.l;

import android.text.TextUtils;
import android.view.ViewStub;
import c.a.d.f.p.n;
import c.a.s0.e1.g;
import c.a.s0.e1.o0;
import c.a.t0.j3.o;
import c.a.t0.j3.y;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f25094f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f25095g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f25096b;

    /* renamed from: c  reason: collision with root package name */
    public o f25097c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.j3.e0.a f25098d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f25099e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(609562467, "Lc/a/t0/u1/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(609562467, "Lc/a/t0/u1/l/a;");
                return;
            }
        }
        f25094f = n.f(TbadkApplication.getInst(), R.dimen.tbds44);
        f25095g = n.k(TbadkApplication.getInst()) - (f25094f * 2);
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
            this.f25098d = (c.a.t0.j3.e0.a) y.q().k(IAdBaseAsyncController.Type.PIC_BANNER, null);
        } catch (ClassCastException unused) {
        }
        this.f25097c = this.f25098d.h(viewStub, tbPageContext);
    }

    public final g a(int i2, boolean z, boolean z2, String str, int i3, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4})) == null) {
            g gVar = new g();
            gVar.f12671j = z;
            if (z) {
                return gVar;
            }
            gVar.f12664c = i2;
            gVar.f12665d = z2 ? this.f25096b : this.a;
            MultiImageView multiImageView = this.f25099e;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f25099e.getCurrentUrlDragImageView().getImageView() != null) {
                float[] resizedSize = this.f25099e.getCurrentUrlDragImageView().getImageView().getResizedSize();
                if (resizedSize.length == 2) {
                    float f2 = resizedSize[0];
                    float f3 = resizedSize[1];
                    gVar.f12666e = f3;
                    if (f3 != 0.0f) {
                        gVar.f12667f = f2 / f3;
                    }
                }
                gVar.f12669h = n.f(TbadkApplication.getInst(), R.dimen.tbds130);
                ImageUrlData imageUrlData = this.f25099e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
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
                    gVar.f12669h += f25094f * Math.min(((Integer) o0.i(TbRichTextView.parse(jSONArray, false).toString(), n.f(TbadkApplication.getInst(), R.dimen.tbds42), f25095g).second).intValue(), 3);
                }
                if (imageUrlData != null) {
                    gVar.f12672k = imageUrlData.isBlockedPic;
                }
            }
            gVar.f12668g = str;
            gVar.f12670i = i3;
            gVar.l = str2;
            gVar.m = str3;
            return gVar;
        }
        return (g) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25098d.onDestroy();
            this.f25097c.onDestroy();
        }
    }

    public void c(MultiImageView multiImageView, boolean z, int i2, boolean z2, String str, int i3, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{multiImageView, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            this.f25099e = multiImageView;
            g a = a(i2, z2, z, str, i3, str2, str3, str4);
            d(this.f25098d.c(a), a, z);
        }
    }

    public final void d(AdvertAppInfo advertAppInfo, g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, advertAppInfo, gVar, z) == null) {
            this.f25097c.a(advertAppInfo, gVar);
            if (advertAppInfo != null) {
                if (z) {
                    this.f25096b = Math.max(this.f25096b, gVar.f12664c);
                } else {
                    this.a = Math.max(this.a, gVar.f12664c);
                }
            }
        }
    }
}
