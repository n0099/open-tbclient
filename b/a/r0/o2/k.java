package b.a.r0.o2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.e.m.e.n;
import b.a.q0.i0.f.b;
import b.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class k implements b.a.q0.i0.f.b, PersonPostModel.d, PersonPostModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public PersonPostModel f23558e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b.a f23559f;

    public k(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23558e = new PersonPostModel(tbPageContext, tbPageContext.getUniqueId(), this, false, PersonPostModel.FROM_PERSON_POLYMERIC);
    }

    @Override // b.a.q0.i0.f.b
    public void a(@Nullable b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f23559f = aVar;
        }
    }

    @Override // b.a.q0.i0.f.b
    public void b(@NonNull String str, @Nullable MetaData metaData, @NonNull Integer num, @NonNull Integer num2, @NonNull Integer num3, @NonNull Integer num4, @NonNull Long l, @NonNull Integer num5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, metaData, num, num2, num3, num4, l, num5}) == null) {
            this.f23558e.fetchPostByBeginThreadId(str, this, metaData, num, num2, num3, num4, l, num5);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void on(PersonPostModel personPostModel, boolean z) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, personPostModel, z) == null) || (aVar = this.f23559f) == null) {
            return;
        }
        aVar.a();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void onResult(PersonPostModel personPostModel, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, personPostModel, z) == null) || this.f23559f == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = personPostModel.threadList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof CardPersonDynamicThreadData) {
                d2 threadData = ((CardPersonDynamicThreadData) next).getThreadData();
                if (!TextUtils.equals(threadData.t1(), "0")) {
                    arrayList.add(threadData);
                }
            }
        }
        this.f23559f.b(arrayList, personPostModel.getDataResMap());
        this.f23559f.a();
    }
}
