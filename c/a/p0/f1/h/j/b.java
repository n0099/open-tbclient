package c.a.p0.f1.h.j;

import android.text.TextUtils;
import c.a.p0.a0.d0.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes3.dex */
public class b extends c.a.p0.a0.d0.i implements p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public CardForum f17465i;

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

    public static boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 == 1 : invokeI.booleanValue;
    }

    @Override // c.a.p0.a0.d0.p
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.showTopDivider = z;
        }
    }

    @Override // c.a.p0.a0.d0.p
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CardForum cardForum = this.f17465i;
            if (cardForum != null) {
                return cardForum.position.intValue();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.a0.d0.p
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a0.d0.p
    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.showBottomDivider = z;
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(getDataList()) > 0 : invokeV.booleanValue;
    }

    public void w(CardForum cardForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cardForum) == null) || cardForum == null) {
            return;
        }
        this.f17465i = cardForum;
        this.mGroupTitle = cardForum.card_title;
        if (cardForum.position != null) {
            p(k() + cardForum.position.intValue());
        } else {
            p(k() + 0);
        }
        if (ListUtils.getCount(cardForum.forum_list) > 0) {
            for (PersonalForum personalForum : cardForum.forum_list) {
                if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                    c.a.p0.a0.d0.g gVar = new c.a.p0.a0.d0.g();
                    gVar.f14970b = personalForum.avatar;
                    gVar.f14971c = personalForum.forum_name;
                    gVar.f14972d = c.a.e.e.m.b.d("" + personalForum.forum_id, -1);
                    gVar.f14973e = personalForum.is_like.intValue() == 1;
                    g(gVar);
                }
            }
        }
    }
}
