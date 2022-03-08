package c.a.r0.u2.l.b;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import c.a.q0.b0.a;
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
/* loaded from: classes2.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ExcContent f23880e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableString f23881f;

    public a(ExcContent excContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {excContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23880e = excContent;
    }

    @Override // c.a.r0.u2.l.b.c
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.u2.l.b.c
    public CharSequence b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c(this.f23880e) : (CharSequence) invokeV.objValue;
    }

    public final SpannableString c(ExcContent excContent) {
        InterceptResult invokeL;
        String str;
        int b2;
        a.C0819a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, excContent)) == null) {
            if (this.f23881f == null && (b2 = TbFaceManager.e().b((str = excContent.text))) != 0) {
                String str2 = SmallTailInfo.EMOTION_PREFIX + TbFaceManager.e().f(str) + SmallTailInfo.EMOTION_SUFFIX;
                this.f23881f = new SpannableString(str2 + " ");
                c.a.q0.e1.n.d dVar = new c.a.q0.e1.n.d(TbadkCoreApplication.getInst().getContext(), b2);
                if (TbFaceManager.e().c(str) != null) {
                    int a = (int) (c2.a() * 0.6d);
                    dVar.setBounds(new Rect(0, 0, a, a));
                } else {
                    dVar.setBounds(new Rect(0, 0, 0, 0));
                }
                this.f23881f.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
            }
            return this.f23881f;
        }
        return (SpannableString) invokeL.objValue;
    }

    @Override // c.a.r0.u2.l.b.d
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
