package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.m15;
import com.baidu.tieba.model.AddPollPostModel;
import com.baidu.tieba.p45;
import com.baidu.tieba.pg;
import com.baidu.tieba.ri;
import com.baidu.tieba.wp9;
import com.baidu.tieba.y15;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
/* loaded from: classes4.dex */
public class VoteView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static final float[] C;
    public static final float[] D;
    public static final float[] E;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbPageContext b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public RecyclerView f;
    public View g;
    public TextView h;
    public String i;
    public long j;
    public PollData k;
    public List<PollOptionData> l;
    public List<Integer> m;
    public View.OnClickListener n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public y15 u;
    public AddPollPostModel v;
    public AddPollPostModel.b w;
    public View.OnClickListener x;
    public RecyclerView.Adapter<e> y;

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.Adapter<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;
            public final /* synthetic */ int b;
            public final /* synthetic */ c c;

            public a(c cVar, e eVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, eVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = eVar;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    VoteView voteView = this.c.a;
                    voteView.F(this.a, !voteView.m.contains(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.b)).getId())));
                    if (!this.c.a.m.contains(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.b)).getId()))) {
                        this.c.a.m.add(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.b)).getId()));
                        PollData pollData = this.c.a.k;
                        VoteView voteView2 = this.c.a;
                        pollData.setPolledValue(voteView2.A(voteView2.m));
                        ((PollOptionData) this.c.a.l.get(this.b)).setNum(((PollOptionData) this.c.a.l.get(this.b)).getNum() + 1);
                        this.c.a.k.getOptions().get(this.b).setNum(((PollOptionData) this.c.a.l.get(this.b)).getNum());
                    } else {
                        this.c.a.m.remove(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.b)).getId()));
                        PollData pollData2 = this.c.a.k;
                        VoteView voteView3 = this.c.a;
                        pollData2.setPolledValue(voteView3.A(voteView3.m));
                        ((PollOptionData) this.c.a.l.get(this.b)).setNum(((PollOptionData) this.c.a.l.get(this.b)).getNum() - 1);
                        this.c.a.k.getOptions().get(this.b).setNum(((PollOptionData) this.c.a.l.get(this.b)).getNum());
                    }
                    this.c.a.K();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ e b;
            public final /* synthetic */ c c;

            public b(c cVar, int i, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i), eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = i;
                this.b = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.c.a.m.add(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.a)).getId()));
                    PollData pollData = this.c.a.k;
                    VoteView voteView = this.c.a;
                    pollData.setPolledValue(voteView.A(voteView.m));
                    ((PollOptionData) this.c.a.l.get(this.a)).setNum(((PollOptionData) this.c.a.l.get(this.a)).getNum() + 1);
                    this.c.a.k.getOptions().get(this.a).setNum(((PollOptionData) this.c.a.l.get(this.a)).getNum());
                    if (this.c.a.x != null) {
                        this.c.a.x.onClick(this.b.b);
                    }
                }
            }
        }

        public c(VoteView voteView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voteView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.l == null) {
                    return 0;
                }
                return this.a.l.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k */
        public void onBindViewHolder(@NonNull e eVar, int i) {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, i) == null) {
                if (this.a.k != null && this.a.k.getOptions() != null && this.a.l != null) {
                    PollOptionData pollOptionData = (PollOptionData) this.a.l.get(i);
                    boolean z4 = true;
                    if (eVar.a == pollOptionData) {
                        z = true;
                    } else {
                        z = false;
                    }
                    eVar.a = pollOptionData;
                    long num = pollOptionData.getNum();
                    if (num == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (this.a.k.getTotalPoll() == num) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean contains = this.a.m.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!this.a.o && !this.a.p) {
                        if (this.a.q) {
                            if (!this.a.r) {
                                this.a.F(eVar, (z && contains) ? false : false);
                            } else {
                                this.a.setSingleUnCheckItemView(eVar);
                            }
                            if ((!this.a.t && this.a.l.size() > 3) || this.a.r) {
                                eVar.b.setOnClickListener(this.a.n);
                            } else {
                                eVar.b.setOnClickListener(new a(this, eVar, i));
                            }
                        } else {
                            this.a.setSingleUnCheckItemView(eVar);
                            if ((!this.a.t && this.a.l.size() > 3) || this.a.r) {
                                eVar.b.setOnClickListener(this.a.n);
                            } else {
                                eVar.b.setOnClickListener(new b(this, i, eVar));
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (this.a.k.getTotalPoll() - num));
                        eVar.d.setLayoutParams(layoutParams);
                        eVar.c.setLayoutParams(layoutParams2);
                        this.a.G(eVar, contains, z3, z2);
                        eVar.g.setText(StringHelper.numberUniformFormatExtraWithRoundVote(num) + this.a.a.getString(R.string.write_vote_num));
                        eVar.b.setOnClickListener(this.a.n);
                    }
                } else {
                    this.a.setSingleUnCheckItemView(eVar);
                    if (this.a.n != null) {
                        eVar.b.setOnClickListener(this.a.n);
                    }
                }
                eVar.b.setText(((PollOptionData) this.a.l.get(i)).getText());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: l */
        public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                return new e(this.a, LayoutInflater.from(this.a.a).inflate(R.layout.view_vote_text_item, viewGroup, false));
            }
            return (e) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AddPollPostModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

        public a(VoteView voteView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voteView;
        }

        @Override // com.baidu.tieba.model.AddPollPostModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (i != 0) {
                    if (!StringUtils.isNull(str)) {
                        this.a.b.showToast(str);
                        return;
                    }
                    return;
                }
                if (this.a.u != null) {
                    this.a.h.setText(this.a.u.b);
                } else {
                    this.a.h.setText(this.a.a.getString(R.string.pb_voted_text));
                }
                PollData pollData = this.a.k;
                VoteView voteView = this.a;
                pollData.setPolledValue(voteView.A(voteView.m));
                boolean z = true;
                this.a.k.setIsPolled(1);
                VoteView voteView2 = this.a;
                if (voteView2.k.getIsPolled() != 1) {
                    z = false;
                }
                voteView2.o = z;
                this.a.k.setTotalNum(this.a.k.getTotalNum() + 1);
                VoteView voteView3 = this.a;
                voteView3.setVoteSubContent(voteView3.getSubContent());
                this.a.k.setTotalPoll(this.a.k.getTotalPoll() + this.a.m.size());
                if (this.a.y != null) {
                    this.a.y.notifyDataSetChanged();
                }
                this.a.K();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

        public b(VoteView voteView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voteView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.u != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_LIVE_POST_CARD_VOTE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.i).param("fid", this.a.j);
                    if (this.a.t) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    TiebaStatic.log(param.param("obj_locate", i));
                    if (this.a.q && ((!this.a.t && this.a.l.size() > 3) || this.a.r)) {
                        if (this.a.n != null) {
                            this.a.n.onClick(view2);
                            return;
                        }
                        return;
                    } else if (this.a.o) {
                        UrlManager.getInstance().dealOneLink(this.a.b, new String[]{this.a.u.c});
                        return;
                    } else {
                        this.a.z();
                        return;
                    }
                }
                this.a.z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VoteView voteView, Context context, int i, boolean z) {
            super(context, i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView, context, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voteView;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PollOptionData a;
        public TextView b;
        public View c;
        public View d;
        public LinearLayout e;
        public ImageView f;
        public TextView g;
        public final /* synthetic */ VoteView h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VoteView voteView, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = voteView;
            this.b = (TextView) view2.findViewById(R.id.vote_item);
            this.c = view2.findViewById(R.id.vote_item_background);
            this.d = view2.findViewById(R.id.vote_item_foreground);
            this.e = (LinearLayout) view2.findViewById(R.id.vote_item_ground);
            this.f = (ImageView) view2.findViewById(R.id.vote_check);
            this.g = (TextView) view2.findViewById(R.id.vote_num);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1177150097, "Lcom/baidu/tbadk/core/view/VoteView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1177150097, "Lcom/baidu/tbadk/core/view/VoteView;");
                return;
            }
        }
        z = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        A = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
        B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
        int i = z;
        C = new float[]{i, i, 0.0f, 0.0f, 0.0f, 0.0f, i, i};
        D = new float[]{0.0f, 0.0f, i, i, i, i, 0.0f, 0.0f};
        int i2 = A;
        E = new float[]{i2, i2, i2, i2, i2, i2, i2, i2};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        InterceptResult invokeV;
        Context context;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.k.getIsMulti() == 1) {
                context = this.a;
                i = R.string.vote_type_multiple;
            } else {
                context = this.a;
                i = R.string.vote_type_single;
            }
            String string = context.getString(i);
            long endTime = this.k.getEndTime();
            if (endTime > 0) {
                Date date = new Date(endTime * 1000);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                str = String.format(this.a.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
            } else {
                str = "";
            }
            if (!StringUtils.isNull(str)) {
                string = string + " · " + str;
            }
            String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(this.k.getTotalNum());
            if (!StringUtils.isNull(numberUniformFormatExtraWithRoundVote)) {
                return string + " · " + numberUniformFormatExtraWithRoundVote + this.a.getString(R.string.write_vote_total);
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoteView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final String A(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            if (size == 0) {
                return "";
            }
            int i = 0;
            while (true) {
                int i2 = size - 1;
                if (i < i2) {
                    sb.append(list.get(i));
                    sb.append(",");
                    i++;
                } else {
                    sb.append(list.get(i2));
                    return sb.toString();
                }
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final void F(e eVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, eVar, z2) == null) {
            eVar.f.setVisibility(0);
            eVar.g.setVisibility(8);
            eVar.b.setGravity(19);
            I(eVar, R.color.CAM_X0207, z2);
            if (z2) {
                SkinManager.setViewTextColor(eVar.b, (int) R.color.CAM_X0302);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.f, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
                return;
            }
            SkinManager.setViewTextColor(eVar.b, (int) R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.f, R.drawable.ic_icon_pure_strok3_24_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.s = R.color.CAM_X0206;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.a = context;
        this.l = new ArrayList();
        this.m = new ArrayList();
        B();
    }

    public final void I(e eVar, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{eVar, Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            eVar.e.setVisibility(8);
            if (z2) {
                p45 d2 = p45.d(eVar.b);
                d2.e(R.string.A_X07);
                d2.o(R.string.J_X04);
                d2.m(R.dimen.L_X01);
                d2.l(R.color.CAM_X0302);
                d2.f(i);
                return;
            }
            p45 d3 = p45.d(eVar.b);
            d3.o(R.string.J_X04);
            d3.m(R.dimen.L_X01);
            d3.l(R.color.CAM_X0902);
            d3.f(i);
        }
    }

    public void setData(PollData pollData, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{pollData, str, Long.valueOf(j)}) == null) && pollData != null && C(pollData, str, j)) {
            List<PollOptionData> options = this.k.getOptions();
            if (!ListUtils.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, B);
                    layoutParams.bottomMargin = 0;
                    this.f.setLayoutParams(layoutParams);
                    this.g.setVisibility(0);
                    this.h.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, eVar) == null) {
            eVar.f.setVisibility(8);
            eVar.g.setVisibility(8);
            eVar.b.setGravity(17);
            SkinManager.setViewTextColor(eVar.b, (int) R.color.CAM_X0105);
            I(eVar, R.color.CAM_X0207, false);
        }
    }

    public void setBgColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.s = i;
        }
    }

    public void setData(List<PollOptionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.l.clear();
            this.l.addAll(list);
            RecyclerView.Adapter<e> adapter = this.y;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) && (imageView = this.e) != null && onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setIsTransmit(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.r = z2;
        }
    }

    public void setMarginTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
            requestLayout();
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.v = new AddPollPostModel(tbPageContext);
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, threadData) != null) || threadData == null) {
            return;
        }
        setData(threadData.getPollData(), threadData.getTid(), threadData.getFid());
        setupLiveThreadVoteInfo(threadData);
    }

    public void setVoteSubContent(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && !StringUtils.isNull(str)) {
            this.d.setText(str);
        }
    }

    public void setVoteTitle(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && !StringUtils.isNull(str)) {
            this.c.setText(str);
        }
    }

    public void setVoteViewDeleteVisibility(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i) == null) && (imageView = this.e) != null) {
            imageView.setVisibility(i);
        }
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048592, this, pollData, str, str2) != null) || pollData == null) {
            return;
        }
        this.t = true;
        if (C(pollData, str, pg.g(str2, 0L))) {
            List<PollOptionData> options = this.k.getOptions();
            if (!ListUtils.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, list) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ri.g(this.a, R.dimen.tbds25);
            this.f.setLayoutParams(layoutParams);
            this.g.setVisibility(8);
            if (this.q && !this.p && !this.o && !this.r) {
                this.h.setVisibility(0);
                this.h.setText(this.a.getString(R.string.pb_vote_text));
                E();
            } else {
                this.h.setVisibility(8);
            }
            setData(list);
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            p45 d2 = p45.d(this);
            d2.o(R.string.J_X05);
            d2.f(this.s);
            if (this.s == R.color.CAM_X0207) {
                SkinManager.setBackgroundResource(this.g, R.drawable.bg_vote_list_transmit_bottom);
            } else {
                SkinManager.setBackgroundResource(this.g, R.drawable.bg_vote_list_bottom);
            }
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            K();
            RecyclerView.Adapter<e> adapter = this.y;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void setupLiveThreadVoteInfo(@NonNull ThreadData threadData) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, threadData) == null) {
            this.u = null;
            m15 taskInfoData = threadData.getTaskInfoData();
            if (taskInfoData == null) {
                return;
            }
            y15 p = taskInfoData.p();
            this.u = p;
            if (p != null && this.h != null) {
                J();
                K();
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_LIVE_POST_CARD_VOTE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.i).param("fid", this.j);
                if (this.t) {
                    i = 2;
                } else {
                    i = 1;
                }
                TiebaStatic.log(param.param("obj_locate", i));
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
            this.c = (TextView) findViewById(R.id.vote_title);
            this.d = (TextView) findViewById(R.id.vote_sub_content);
            this.e = (ImageView) findViewById(R.id.vote_view_delete);
            this.f = (RecyclerView) findViewById(R.id.vote_item_list);
            this.g = findViewById(R.id.vote_list_bottom);
            this.h = (TextView) findViewById(R.id.vote_view_btn);
            this.e.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            this.h.setOnClickListener(this.x);
            this.f.setLayoutManager(new d(this, this.a, 1, false));
            this.f.setNestedScrollingEnabled(false);
            this.f.setAdapter(this.y);
            this.y.notifyDataSetChanged();
        }
    }

    public final void J() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || getContext() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
        Context context = getContext();
        if (!this.t && this.l.size() > 3) {
            i = R.dimen.M_H_X007;
        } else {
            i = R.dimen.tbds0;
        }
        int g = ri.g(context, i);
        int g2 = ri.g(getContext(), R.dimen.M_H_X007);
        int g3 = ri.g(getContext(), R.dimen.M_W_X006);
        marginLayoutParams.width = -1;
        marginLayoutParams.height = ri.g(getContext(), R.dimen.tbds104);
        marginLayoutParams.setMargins(g3, g, g3, g2);
        this.h.setLayoutParams(marginLayoutParams);
    }

    public final boolean C(PollData pollData, String str, long j) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pollData, str, Long.valueOf(j)})) == null) {
            boolean z4 = false;
            if (this.k == pollData && Objects.equals(this.i, str) && this.j == j) {
                return false;
            }
            this.i = str;
            this.j = j;
            this.k = pollData;
            if (pollData.getIsPolled() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.o = z2;
            this.m.clear();
            if (this.o && !StringUtils.isNull(this.k.getPolledValue())) {
                for (String str2 : this.k.getPolledValue().split(",")) {
                    this.m.add(Integer.valueOf(Integer.parseInt(str2)));
                }
            }
            if (this.k.getLastTime() <= 0 && this.k.getLastTime() != -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.p = z3;
            if (this.k.getIsMulti() == 1) {
                z4 = true;
            }
            this.q = z4;
            if (!StringUtils.isNull(this.k.getTitle())) {
                this.c.setText(this.k.getTitle());
            }
            setVoteSubContent(getSubContent());
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || getContext() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
        int g = ri.g(getContext(), R.dimen.tbds16);
        int g2 = ri.g(getContext(), R.dimen.tbds54);
        marginLayoutParams.width = ri.g(getContext(), R.dimen.tbds298);
        marginLayoutParams.height = ri.g(getContext(), R.dimen.tbds94);
        marginLayoutParams.setMargins(0, g, 0, g2);
        this.h.setLayoutParams(marginLayoutParams);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            String A2 = A(this.m);
            if (this.b != null && this.v != null && !StringUtils.isNull(this.i) && this.w != null && !StringUtils.isNull(A2) && this.k != null) {
                this.v.Z(pg.g(this.i, -1L));
                this.v.Y(this.w);
                this.v.W(this.i, A2, this.j);
            }
        }
    }

    public final void G(e eVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{eVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            eVar.f.setVisibility(8);
            eVar.g.setVisibility(0);
            eVar.b.setGravity(19);
            int i = R.color.CAM_X0209;
            if (z2) {
                SkinManager.setViewTextColor(eVar.b, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(eVar.g, (int) R.color.CAM_X0302);
                if (z3) {
                    I(eVar, R.color.CAM_X0905, z2);
                    return;
                }
            } else {
                SkinManager.setViewTextColor(eVar.b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(eVar.g, (int) R.color.CAM_X0105);
                if (z4) {
                    I(eVar, R.color.CAM_X0207, z2);
                    return;
                } else if (z3) {
                    I(eVar, R.color.CAM_X0209, z2);
                    return;
                }
            }
            if (z2) {
                i = R.color.CAM_X0905;
            }
            H(eVar, i, R.color.CAM_X0207, z2);
        }
    }

    public final void H(e eVar, int i, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            eVar.e.setVisibility(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(C);
            gradientDrawable.setColor(SkinManager.getColor(i));
            eVar.d.setBackgroundDrawable(gradientDrawable);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadii(D);
            gradientDrawable2.setColor(SkinManager.getColor(i2));
            eVar.c.setBackgroundDrawable(gradientDrawable2);
            if (z2) {
                p45 d2 = p45.d(eVar.b);
                d2.e(R.string.A_X07);
                d2.o(R.string.J_X04);
                d2.m(R.dimen.L_X01);
                d2.l(R.color.CAM_X0302);
                d2.f(i2);
                return;
            }
            p45 d3 = p45.d(eVar.b);
            d3.o(R.string.J_X04);
            d3.m(R.dimen.L_X01);
            d3.l(R.color.CAM_X0902);
            d3.f(i2);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z2 = true;
            if (this.u != null) {
                p45 d2 = p45.d(this.h);
                d2.o(R.string.J_X01);
                d2.i(R.color.CAM_X0302);
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
                if (!this.o && !ListUtils.isEmpty(this.m) && this.m.size() > 0) {
                    this.h.setText(this.a.getString(R.string.pb_vote_text));
                    this.h.setEnabled(true);
                    this.h.setClickable(true);
                } else if (this.o) {
                    this.h.setText(this.u.b);
                    this.h.setEnabled(true);
                    this.h.setClickable(true);
                } else {
                    this.h.setText(this.u.a);
                    this.h.setEnabled(false);
                    TextView textView = this.h;
                    if (!this.q || ((this.t || this.l.size() <= 3) && !this.r)) {
                        z2 = false;
                    }
                    textView.setClickable(z2);
                }
                this.h.setVisibility(0);
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(E);
            gradientDrawable.setColor(wp9.a(SkinManager.getColor(R.color.CAM_X0302), 0.08f));
            this.h.setBackgroundDrawable(gradientDrawable);
            if (!this.o && !ListUtils.isEmpty(this.m) && this.m.size() > 0) {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0302);
                this.h.setEnabled(true);
                return;
            }
            this.h.setTextColor(wp9.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.h.setEnabled(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
            AddPollPostModel addPollPostModel = this.v;
            if (addPollPostModel != null && !this.o && !this.p && !this.r) {
                addPollPostModel.registerListener();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            AddPollPostModel addPollPostModel = this.v;
            if (addPollPostModel != null) {
                addPollPostModel.unRegisterListener();
            }
        }
    }
}
