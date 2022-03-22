package c.a.p0.w2.n.b;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import c.a.o0.b0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExcContent a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableString f20405b;

    public a(ExcContent excContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {excContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = excContent;
    }

    @Override // c.a.p0.w2.n.b.c
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.w2.n.b.c
    public CharSequence b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c(this.a) : (CharSequence) invokeV.objValue;
    }

    public final SpannableString c(ExcContent excContent) {
        InterceptResult invokeL;
        String str;
        int b2;
        a.C0786a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, excContent)) == null) {
            if (this.f20405b == null && (b2 = TbFaceManager.e().b((str = excContent.text))) != 0) {
                String str2 = SmallTailInfo.EMOTION_PREFIX + TbFaceManager.e().f(str) + SmallTailInfo.EMOTION_SUFFIX;
                this.f20405b = new SpannableString(str2 + " ");
                c.a.o0.e1.n.d dVar = new c.a.o0.e1.n.d(TbadkCoreApplication.getInst().getContext(), b2);
                if (TbFaceManager.e().c(str) != null) {
                    int a = (int) (c2.a() * 0.6d);
                    dVar.setBounds(new Rect(0, 0, a, a));
                } else {
                    dVar.setBounds(new Rect(0, 0, 0, 0));
                }
                this.f20405b.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
            }
            return this.f20405b;
        }
        return (SpannableString) invokeL.objValue;
    }

    @Override // c.a.p0.w2.n.b.d
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
