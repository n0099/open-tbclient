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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lj8;
import com.baidu.tieba.model.AddPollPostModel;
import com.baidu.tieba.ns4;
import com.baidu.tieba.pg;
import com.baidu.tieba.ri;
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
/* loaded from: classes3.dex */
public class VoteView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final float[] B;
    public static final float[] C;
    public static final float[] D;
    public static final int y;
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
    public AddPollPostModel u;
    public AddPollPostModel.b v;
    public View.OnClickListener w;
    public RecyclerView.Adapter<e> x;

    /* loaded from: classes3.dex */
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
                    if (StringUtils.isNull(str)) {
                        return;
                    }
                    this.a.b.showToast(str);
                    return;
                }
                this.a.h.setText(this.a.a.getString(R.string.obfuscated_res_0x7f0f0e0a));
                PollData pollData = this.a.k;
                VoteView voteView = this.a;
                pollData.setPolledValue(voteView.z(voteView.m));
                this.a.k.setIsPolled(1);
                VoteView voteView2 = this.a;
                voteView2.o = voteView2.k.getIsPolled() == 1;
                this.a.k.setTotalNum(this.a.k.getTotalNum() + 1);
                VoteView voteView3 = this.a;
                voteView3.setVoteSubContent(voteView3.getSubContent());
                this.a.k.setTotalPoll(this.a.k.getTotalPoll() + this.a.m.size());
                if (this.a.x != null) {
                    this.a.x.notifyDataSetChanged();
                }
                this.a.H();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                VoteView voteView = this.a;
                String z = voteView.z(voteView.m);
                if (this.a.b == null || this.a.u == null || StringUtils.isNull(this.a.i) || this.a.v == null || StringUtils.isNull(z) || this.a.k == null) {
                    return;
                }
                this.a.u.E(pg.g(this.a.i, -1L));
                this.a.u.D(this.a.v);
                this.a.u.B(this.a.i, z, this.a.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.Adapter<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

        /* loaded from: classes3.dex */
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
                    voteView.D(this.a, !voteView.m.contains(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.b)).getId())));
                    if (!this.c.a.m.contains(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.b)).getId()))) {
                        this.c.a.m.add(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.b)).getId()));
                        PollData pollData = this.c.a.k;
                        VoteView voteView2 = this.c.a;
                        pollData.setPolledValue(voteView2.z(voteView2.m));
                        ((PollOptionData) this.c.a.l.get(this.b)).setNum(((PollOptionData) this.c.a.l.get(this.b)).getNum() + 1);
                        this.c.a.k.getOptions().get(this.b).setNum(((PollOptionData) this.c.a.l.get(this.b)).getNum());
                    } else {
                        this.c.a.m.remove(Integer.valueOf(((PollOptionData) this.c.a.l.get(this.b)).getId()));
                        PollData pollData2 = this.c.a.k;
                        VoteView voteView3 = this.c.a;
                        pollData2.setPolledValue(voteView3.z(voteView3.m));
                        ((PollOptionData) this.c.a.l.get(this.b)).setNum(((PollOptionData) this.c.a.l.get(this.b)).getNum() - 1);
                        this.c.a.k.getOptions().get(this.b).setNum(((PollOptionData) this.c.a.l.get(this.b)).getNum());
                    }
                    this.c.a.H();
                }
            }
        }

        /* loaded from: classes3.dex */
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
                    pollData.setPolledValue(voteView.z(voteView.m));
                    ((PollOptionData) this.c.a.l.get(this.a)).setNum(((PollOptionData) this.c.a.l.get(this.a)).getNum() + 1);
                    this.c.a.k.getOptions().get(this.a).setNum(((PollOptionData) this.c.a.l.get(this.a)).getNum());
                    if (this.c.a.w != null) {
                        this.c.a.w.onClick(this.b.a);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(@NonNull e eVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, eVar, i) == null) {
                if (this.a.k == null || this.a.k.getOptions() == null || this.a.l == null) {
                    this.a.setSingleUnCheckItemView(eVar);
                    if (this.a.n != null) {
                        eVar.a.setOnClickListener(this.a.n);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) this.a.l.get(i);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = this.a.k.getTotalPoll() == num;
                    boolean contains = this.a.m.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!this.a.o && !this.a.p) {
                        if (this.a.q) {
                            if (!this.a.r) {
                                this.a.D(eVar, false);
                            } else {
                                this.a.setSingleUnCheckItemView(eVar);
                            }
                            if ((!this.a.t && this.a.l.size() > 3) || this.a.r) {
                                eVar.a.setOnClickListener(this.a.n);
                            } else {
                                eVar.a.setOnClickListener(new a(this, eVar, i));
                            }
                        } else {
                            this.a.setSingleUnCheckItemView(eVar);
                            if ((!this.a.t && this.a.l.size() > 3) || this.a.r) {
                                eVar.a.setOnClickListener(this.a.n);
                            } else {
                                eVar.a.setOnClickListener(new b(this, i, eVar));
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (this.a.k.getTotalPoll() - num));
                        eVar.c.setLayoutParams(layoutParams);
                        eVar.b.setLayoutParams(layoutParams2);
                        this.a.E(eVar, contains, z2, z);
                        eVar.f.setText(StringHelper.numberUniformFormatExtraWithRoundVote(num) + this.a.a.getString(R.string.obfuscated_res_0x7f0f15f1));
                        eVar.a.setOnClickListener(this.a.n);
                    }
                }
                eVar.a.setText(((PollOptionData) this.a.l.get(i)).getText());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: e */
        public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new e(this.a, LayoutInflater.from(this.a.a).inflate(R.layout.obfuscated_res_0x7f0d08e0, viewGroup, false)) : (e) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a.l == null) {
                    return 0;
                }
                return this.a.l.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

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

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;
        public View c;
        public LinearLayout d;
        public ImageView e;
        public TextView f;
        public final /* synthetic */ VoteView g;

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
            this.g = voteView;
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925cd);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0925ce);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f0925cf);
            this.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925d0);
            this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925c7);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d7);
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
        y = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        z = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
        A = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
        int i = y;
        B = new float[]{i, i, 0.0f, 0.0f, 0.0f, 0.0f, i, i};
        C = new float[]{0.0f, 0.0f, i, i, i, i, 0.0f, 0.0f};
        int i2 = z;
        D = new float[]{i2, i2, i2, i2, i2, i2, i2, i2};
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
                i = R.string.obfuscated_res_0x7f0f158c;
            } else {
                context = this.a;
                i = R.string.obfuscated_res_0x7f0f158d;
            }
            String string = context.getString(i);
            long endTime = this.k.getEndTime();
            if (endTime > 0) {
                Date date = new Date(endTime * 1000);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                str = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f15ed), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
            } else {
                str = "";
            }
            if (!StringUtils.isNull(str)) {
                string = string + " · " + str;
            }
            String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(this.k.getTotalNum());
            if (StringUtils.isNull(numberUniformFormatExtraWithRoundVote)) {
                return string;
            }
            return string + " · " + numberUniformFormatExtraWithRoundVote + this.a.getString(R.string.obfuscated_res_0x7f0f15f5);
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, eVar) == null) {
            eVar.e.setVisibility(8);
            eVar.f.setVisibility(8);
            eVar.a.setGravity(17);
            SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0105);
            G(eVar, R.color.CAM_X0207, false);
        }
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, list) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ri.f(this.a, R.dimen.tbds25);
            this.f.setLayoutParams(layoutParams);
            this.g.setVisibility(8);
            if (this.q && !this.p && !this.o && !this.r) {
                this.h.setVisibility(0);
                this.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e08));
            } else {
                this.h.setVisibility(8);
            }
            setData(list);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08df, (ViewGroup) this, true);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0925e3);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0925dc);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0925ee);
            this.f = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0925d1);
            this.g = findViewById(R.id.obfuscated_res_0x7f0925d5);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0925ed);
            this.e.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080803, WebPManager.ResourceStateType.NORMAL));
            this.h.setOnClickListener(this.w);
            this.f.setLayoutManager(new d(this, this.a, 1, false));
            this.f.setNestedScrollingEnabled(false);
            this.f.setAdapter(this.x);
            this.x.notifyDataSetChanged();
        }
    }

    public final void B(PollData pollData, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{pollData, str, Long.valueOf(j)}) == null) {
            this.i = str;
            this.j = j;
            this.k = pollData;
            this.o = pollData.getIsPolled() == 1;
            this.m.clear();
            if (this.o && !StringUtils.isNull(this.k.getPolledValue())) {
                for (String str2 : this.k.getPolledValue().split(",")) {
                    this.m.add(Integer.valueOf(Integer.parseInt(str2)));
                }
            }
            this.p = this.k.getLastTime() <= 0 && this.k.getLastTime() != -1;
            this.q = this.k.getIsMulti() == 1;
            if (!StringUtils.isNull(this.k.getTitle())) {
                this.c.setText(this.k.getTitle());
            }
            setVoteSubContent(getSubContent());
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            ns4 d2 = ns4.d(this);
            d2.n(R.string.J_X05);
            d2.f(this.s);
            if (this.s == R.color.CAM_X0207) {
                SkinManager.setBackgroundResource(this.g, R.drawable.bg_vote_list_transmit_bottom);
            } else {
                SkinManager.setBackgroundResource(this.g, R.drawable.bg_vote_list_bottom);
            }
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            H();
            RecyclerView.Adapter<e> adapter = this.x;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public final void D(e eVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, eVar, z2) == null) {
            eVar.e.setVisibility(0);
            eVar.f.setVisibility(8);
            eVar.a.setGravity(19);
            G(eVar, R.color.CAM_X0207, z2);
            if (z2) {
                SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0302);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.e, R.drawable.obfuscated_res_0x7f080611, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
                return;
            }
            SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.e, R.drawable.obfuscated_res_0x7f080605, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public final void E(e eVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{eVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            eVar.e.setVisibility(8);
            eVar.f.setVisibility(0);
            eVar.a.setGravity(19);
            int i = R.color.CAM_X0209;
            if (z2) {
                SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(eVar.f, (int) R.color.CAM_X0302);
                if (z3) {
                    G(eVar, R.color.CAM_X0905, z2);
                    return;
                }
            } else {
                SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(eVar.f, (int) R.color.CAM_X0105);
                if (z4) {
                    G(eVar, R.color.CAM_X0207, z2);
                    return;
                } else if (z3) {
                    G(eVar, R.color.CAM_X0209, z2);
                    return;
                }
            }
            if (z2) {
                i = R.color.CAM_X0905;
            }
            F(eVar, i, R.color.CAM_X0207, z2);
        }
    }

    public final void F(e eVar, int i, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{eVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            eVar.d.setVisibility(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(B);
            gradientDrawable.setColor(SkinManager.getColor(i));
            eVar.c.setBackgroundDrawable(gradientDrawable);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadii(C);
            gradientDrawable2.setColor(SkinManager.getColor(i2));
            eVar.b.setBackgroundDrawable(gradientDrawable2);
            if (z2) {
                ns4 d2 = ns4.d(eVar.a);
                d2.e(R.string.A_X07);
                d2.n(R.string.J_X04);
                d2.l(R.dimen.L_X01);
                d2.k(R.color.CAM_X0302);
                d2.f(i2);
                return;
            }
            ns4 d3 = ns4.d(eVar.a);
            d3.n(R.string.J_X04);
            d3.l(R.dimen.L_X01);
            d3.k(R.color.CAM_X0902);
            d3.f(i2);
        }
    }

    public final void G(e eVar, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{eVar, Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            eVar.d.setVisibility(8);
            if (z2) {
                ns4 d2 = ns4.d(eVar.a);
                d2.e(R.string.A_X07);
                d2.n(R.string.J_X04);
                d2.l(R.dimen.L_X01);
                d2.k(R.color.CAM_X0302);
                d2.f(i);
                return;
            }
            ns4 d3 = ns4.d(eVar.a);
            d3.n(R.string.J_X04);
            d3.l(R.dimen.L_X01);
            d3.k(R.color.CAM_X0902);
            d3.f(i);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(D);
            gradientDrawable.setColor(lj8.a(SkinManager.getColor(R.color.CAM_X0302), 0.08f));
            this.h.setBackgroundDrawable(gradientDrawable);
            if (!this.o && !ListUtils.isEmpty(this.m) && this.m.size() > 0) {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0302);
                this.h.setEnabled(true);
                return;
            }
            this.h.setTextColor(lj8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.h.setEnabled(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            AddPollPostModel addPollPostModel = this.u;
            if (addPollPostModel == null || this.o || this.p || this.r) {
                return;
            }
            addPollPostModel.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            AddPollPostModel addPollPostModel = this.u;
            if (addPollPostModel != null) {
                addPollPostModel.unRegisterListener();
            }
        }
    }

    public void setBgColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.s = i;
        }
    }

    public void setData(PollData pollData, String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{pollData, str, Long.valueOf(j)}) == null) || pollData == null) {
            return;
        }
        B(pollData, str, j);
        List<PollOptionData> options = this.k.getOptions();
        if (ListUtils.isEmpty(options)) {
            return;
        }
        if (options.size() > 3) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, A);
            layoutParams.bottomMargin = 0;
            this.f.setLayoutParams(layoutParams);
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            setData(options.subList(0, 4));
            return;
        }
        setViewWithAllData(options);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, pollData, str, str2) == null) || pollData == null) {
            return;
        }
        this.t = true;
        B(pollData, str, pg.g(str2, 0L));
        List<PollOptionData> options = this.k.getOptions();
        if (ListUtils.isEmpty(options)) {
            return;
        }
        setViewWithAllData(options);
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) || (imageView = this.e) == null || onClickListener == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setIsTransmit(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) {
            this.r = z2;
        }
    }

    public void setMarginTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
            requestLayout();
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.u = new AddPollPostModel(tbPageContext);
        }
    }

    public void setVoteSubContent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.d.setText(str);
    }

    public void setVoteTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.c.setText(str);
    }

    public void setVoteViewDeleteVisibility(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || (imageView = this.e) == null) {
            return;
        }
        imageView.setVisibility(i);
    }

    public final String z(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048598, this, list)) != null) {
            return (String) invokeL.objValue;
        }
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
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        this.a = context;
        this.l = new ArrayList();
        this.m = new ArrayList();
        A();
    }

    public void setData(List<PollOptionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.l.clear();
            this.l.addAll(list);
            RecyclerView.Adapter<e> adapter = this.x;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
