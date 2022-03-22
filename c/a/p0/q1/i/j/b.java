package c.a.p0.q1.i.j;

import android.text.TextUtils;
import c.a.p0.h0.e0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes2.dex */
public class b extends c.a.p0.h0.e0.i implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CardForum f17442e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == 1 : invokeI.booleanValue;
    }

    @Override // c.a.p0.h0.e0.q
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.showTopDivider = z;
        }
    }

    @Override // c.a.p0.h0.e0.q
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CardForum cardForum = this.f17442e;
            if (cardForum != null) {
                return cardForum.position.intValue();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.h0.e0.q
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(getDataList()) > 0 : invokeV.booleanValue;
    }

    public void s(CardForum cardForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cardForum) == null) || cardForum == null) {
            return;
        }
        this.f17442e = cardForum;
        this.mGroupTitle = cardForum.card_title;
        if (cardForum.position != null) {
            m(i() + cardForum.position.intValue());
        } else {
            m(i() + 0);
        }
        if (ListUtils.getCount(cardForum.forum_list) > 0) {
            for (PersonalForum personalForum : cardForum.forum_list) {
                if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                    c.a.p0.h0.e0.g gVar = new c.a.p0.h0.e0.g();
                    gVar.f15326b = personalForum.avatar;
                    gVar.f15327c = personalForum.forum_name;
                    gVar.f15328d = c.a.d.f.m.b.e("" + personalForum.forum_id, -1);
                    gVar.f15329e = personalForum.is_like.intValue() == 1;
                    e(gVar);
                }
            }
        }
    }

    @Override // c.a.p0.h0.e0.q
    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.showBottomDivider = z;
        }
    }
}
