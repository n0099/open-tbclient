package c.a.q0.i2.k.e.e1;

import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.d1.m.i;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f19412a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19413b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19414c;

    /* renamed from: d  reason: collision with root package name */
    public int f19415d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f19416e;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f19417a;

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
            this.f19417a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                this.f19417a.b(iVar);
                this.f19417a.d(iVar);
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
        this.f19412a = 3;
        this.f19415d = 0;
        this.f19416e = new a(this, 2016502);
        this.f19413b = tbPageContext;
        this.f19414c = (TextView) view.findViewById(R.id.pb_list_video_item_play_count);
        c(TbadkCoreApplication.getInst().getSkinType());
        tbPageContext.registerListener(this.f19416e);
    }

    public final void b(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        int i2 = this.f19415d + 1;
        this.f19415d = i2;
        iVar.l(i2);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.f19412a != i2) {
                this.f19414c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_pb_video_num_gray, 0, 0, 0);
                this.f19414c.setCompoundDrawablePadding(l.g(this.f19413b.getPageActivity(), R.dimen.ds12));
                SkinManager.setViewTextColor(this.f19414c, R.color.CAM_X0108, 1);
            }
            this.f19412a = i2;
        }
    }

    public void d(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) || this.f19414c == null || iVar == null) {
            return;
        }
        int e2 = iVar.e();
        int i2 = this.f19415d;
        if (e2 < i2) {
            iVar.l(i2);
        } else {
            this.f19415d = iVar.e();
        }
        this.f19414c.setText(StringHelper.numberUniformFormat(this.f19415d));
    }
}
