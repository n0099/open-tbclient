package c.a.p0.s4.u.o;

import android.view.View;
import android.widget.RelativeLayout;
import c.a.o0.r.t.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f18538b;

    /* renamed from: c  reason: collision with root package name */
    public VoteView f18539c;

    /* renamed from: d  reason: collision with root package name */
    public WriteVoteData f18540d;

    /* renamed from: c.a.p0.s4.u.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1399a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.s4.u.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1400a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View$OnClickListenerC1399a a;

            public C1400a(View$OnClickListenerC1399a view$OnClickListenerC1399a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC1399a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view$OnClickListenerC1399a;
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.a.a.f18540d = null;
                    this.a.a.h(false);
                    aVar.dismiss();
                }
            }
        }

        /* renamed from: c.a.p0.s4.u.o.a$a$b */
        /* loaded from: classes2.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(View$OnClickListenerC1399a view$OnClickListenerC1399a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC1399a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public View$OnClickListenerC1399a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.a.getPageActivity());
                aVar.setTitle(this.a.a.getString(R.string.obfuscated_res_0x7f0f1530));
                aVar.setTitleShowCenter(true);
                aVar.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f152f));
                aVar.setMessageShowCenter(true);
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f048e, new C1400a(this));
                aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new b(this));
                aVar.create(this.a.a).show();
            }
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f18538b = relativeLayout;
        VoteView voteView = new VoteView(this.a.getPageActivity());
        this.f18539c = voteView;
        voteView.setPageContext(this.a);
        this.f18539c.setDeleteOnClickListener(new View$OnClickListenerC1399a(this));
        this.f18539c.setVoteViewDeleteVisibility(0);
        this.f18538b.addView(this.f18539c);
        h(false);
    }

    public WriteVoteData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18540d : (WriteVoteData) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f18539c.C(i);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (voteView = this.f18539c) == null || onClickListener == null) {
            return;
        }
        voteView.setOnItemClickListener(onClickListener);
    }

    public void f(View.OnClickListener onClickListener) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || (voteView = this.f18539c) == null || onClickListener == null) {
            return;
        }
        voteView.setOnClickListener(onClickListener);
    }

    public void g(WriteVoteData writeVoteData) {
        VoteView voteView;
        TbPageContext<WriteActivity> tbPageContext;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, writeVoteData) == null) || writeVoteData == null || (voteView = this.f18539c) == null) {
            return;
        }
        this.f18540d = writeVoteData;
        voteView.setVoteTitle(writeVoteData.getTitle());
        if (this.f18540d.getIs_multi() == 1) {
            tbPageContext = this.a;
            i = R.string.obfuscated_res_0x7f0f153b;
        } else {
            tbPageContext = this.a;
            i = R.string.obfuscated_res_0x7f0f153c;
        }
        String string = tbPageContext.getString(i);
        int expire_type = this.f18540d.getExpire_type();
        if (expire_type > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, expire_type);
            str = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f1597), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            str = "";
        }
        if (StringUtils.isNull(str)) {
            this.f18539c.setVoteSubContent(string);
        } else {
            VoteView voteView2 = this.f18539c;
            voteView2.setVoteSubContent(string + " · " + str);
        }
        ArrayList arrayList = new ArrayList();
        for (WriteVoteItemData writeVoteItemData : this.f18540d.getOptions()) {
            PollOptionData pollOptionData = new PollOptionData();
            pollOptionData.setId(writeVoteItemData.getId());
            pollOptionData.setText(writeVoteItemData.getText());
            arrayList.add(pollOptionData);
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (arrayList.size() > 3) {
            this.f18539c.setData(arrayList.subList(0, 3));
        } else {
            this.f18539c.setData(arrayList);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f18538b.setVisibility(z ? 0 : 8);
            this.a.getOrignalPage().changeToolButtonStatus();
            this.a.getOrignalPage().upDateVoteInfo(this.f18540d);
        }
    }
}
