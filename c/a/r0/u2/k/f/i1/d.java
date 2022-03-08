package c.a.r0.u2.k.f.i1;

import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.q0.e1.n.j;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f23640b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23641c;

    /* renamed from: d  reason: collision with root package name */
    public int f23642d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f23643e;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                j jVar = (j) customResponsedMessage.getData();
                this.a.b(jVar);
                this.a.d(jVar);
            }
        }
    }

    public d(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f23642d = 0;
        this.f23643e = new a(this, 2016502);
        this.f23640b = tbPageContext;
        this.f23641c = (TextView) view.findViewById(R.id.pb_list_video_item_play_count);
        c(TbadkCoreApplication.getInst().getSkinType());
        tbPageContext.registerListener(this.f23643e);
    }

    public final void b(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || jVar == null) {
            return;
        }
        int i2 = this.f23642d + 1;
        this.f23642d = i2;
        jVar.i(i2);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.a != i2) {
                this.f23641c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_pb_video_num_gray, 0, 0, 0);
                this.f23641c.setCompoundDrawablePadding(n.f(this.f23640b.getPageActivity(), R.dimen.ds12));
                SkinManager.setViewTextColor(this.f23641c, R.color.CAM_X0108, 1);
            }
            this.a = i2;
        }
    }

    public void d(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) || this.f23641c == null || jVar == null) {
            return;
        }
        int d2 = jVar.d();
        int i2 = this.f23642d;
        if (d2 < i2) {
            jVar.i(i2);
        } else {
            this.f23642d = jVar.d();
        }
        this.f23641c.setText(StringHelper.numberUniformFormat(this.f23642d));
    }
}
