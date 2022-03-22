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
import c.a.d.f.p.n;
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
import com.baidu.tieba.model.AddPollPostModel;
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
/* loaded from: classes5.dex */
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

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f30209b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30210c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30211d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30212e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f30213f;

    /* renamed from: g  reason: collision with root package name */
    public View f30214g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f30215h;
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

    /* loaded from: classes5.dex */
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
                    this.a.f30209b.showToast(str);
                    return;
                }
                this.a.f30215h.setText(this.a.a.getString(R.string.obfuscated_res_0x7f0f0dd3));
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

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VoteView voteView = this.a;
                String z = voteView.z(voteView.m);
                if (this.a.f30209b == null || this.a.u == null || StringUtils.isNull(this.a.i) || this.a.v == null || StringUtils.isNull(z) || this.a.k == null) {
                    return;
                }
                this.a.u.D(c.a.d.f.m.b.g(this.a.i, -1L));
                this.a.u.C(this.a.v);
                this.a.u.A(this.a.i, z, this.a.j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.Adapter<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f30216b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f30217c;

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
                this.f30217c = cVar;
                this.a = eVar;
                this.f30216b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    VoteView voteView = this.f30217c.a;
                    voteView.D(this.a, !voteView.m.contains(Integer.valueOf(((PollOptionData) this.f30217c.a.l.get(this.f30216b)).getId())));
                    if (!this.f30217c.a.m.contains(Integer.valueOf(((PollOptionData) this.f30217c.a.l.get(this.f30216b)).getId()))) {
                        this.f30217c.a.m.add(Integer.valueOf(((PollOptionData) this.f30217c.a.l.get(this.f30216b)).getId()));
                        PollData pollData = this.f30217c.a.k;
                        VoteView voteView2 = this.f30217c.a;
                        pollData.setPolledValue(voteView2.z(voteView2.m));
                        ((PollOptionData) this.f30217c.a.l.get(this.f30216b)).setNum(((PollOptionData) this.f30217c.a.l.get(this.f30216b)).getNum() + 1);
                        this.f30217c.a.k.getOptions().get(this.f30216b).setNum(((PollOptionData) this.f30217c.a.l.get(this.f30216b)).getNum());
                    } else {
                        this.f30217c.a.m.remove(Integer.valueOf(((PollOptionData) this.f30217c.a.l.get(this.f30216b)).getId()));
                        PollData pollData2 = this.f30217c.a.k;
                        VoteView voteView3 = this.f30217c.a;
                        pollData2.setPolledValue(voteView3.z(voteView3.m));
                        ((PollOptionData) this.f30217c.a.l.get(this.f30216b)).setNum(((PollOptionData) this.f30217c.a.l.get(this.f30216b)).getNum() - 1);
                        this.f30217c.a.k.getOptions().get(this.f30216b).setNum(((PollOptionData) this.f30217c.a.l.get(this.f30216b)).getNum());
                    }
                    this.f30217c.a.H();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f30218b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f30219c;

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
                this.f30219c = cVar;
                this.a = i;
                this.f30218b = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f30219c.a.m.add(Integer.valueOf(((PollOptionData) this.f30219c.a.l.get(this.a)).getId()));
                    PollData pollData = this.f30219c.a.k;
                    VoteView voteView = this.f30219c.a;
                    pollData.setPolledValue(voteView.z(voteView.m));
                    ((PollOptionData) this.f30219c.a.l.get(this.a)).setNum(((PollOptionData) this.f30219c.a.l.get(this.a)).getNum() + 1);
                    this.f30219c.a.k.getOptions().get(this.a).setNum(((PollOptionData) this.f30219c.a.l.get(this.a)).getNum());
                    if (this.f30219c.a.w != null) {
                        this.f30219c.a.w.onClick(this.f30218b.a);
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
                        eVar.f30221c.setLayoutParams(layoutParams);
                        eVar.f30220b.setLayoutParams(layoutParams2);
                        this.a.E(eVar, contains, z2, z);
                        eVar.f30224f.setText(StringHelper.numberUniformFormatExtraWithRoundVote(num) + this.a.a.getString(R.string.obfuscated_res_0x7f0f159b));
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
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new e(this.a, LayoutInflater.from(this.a.a).inflate(R.layout.obfuscated_res_0x7f0d08ae, viewGroup, false)) : (e) invokeLI.objValue;
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f30220b;

        /* renamed from: c  reason: collision with root package name */
        public View f30221c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f30222d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f30223e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f30224f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VoteView f30225g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VoteView voteView, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView, view};
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
            this.f30225g = voteView;
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09241e);
            this.f30220b = view.findViewById(R.id.obfuscated_res_0x7f09241f);
            this.f30221c = view.findViewById(R.id.obfuscated_res_0x7f092420);
            this.f30222d = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f092421);
            this.f30223e = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092418);
            this.f30224f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092428);
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
                i = R.string.obfuscated_res_0x7f0f153b;
            } else {
                context = this.a;
                i = R.string.obfuscated_res_0x7f0f153c;
            }
            String string = context.getString(i);
            long endTime = this.k.getEndTime();
            if (endTime > 0) {
                Date date = new Date(endTime * 1000);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                str = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f1597), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
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
            return string + " · " + numberUniformFormatExtraWithRoundVote + this.a.getString(R.string.obfuscated_res_0x7f0f159f);
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, eVar) == null) {
            eVar.f30223e.setVisibility(8);
            eVar.f30224f.setVisibility(8);
            eVar.a.setGravity(17);
            SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0105);
            G(eVar, R.color.CAM_X0207, false);
        }
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, list) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = n.f(this.a, R.dimen.tbds25);
            this.f30213f.setLayoutParams(layoutParams);
            this.f30214g.setVisibility(8);
            if (this.q && !this.p && !this.o && !this.r) {
                this.f30215h.setVisibility(0);
                this.f30215h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0dd1));
            } else {
                this.f30215h.setVisibility(8);
            }
            setData(list);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08ad, (ViewGroup) this, true);
            this.f30210c = (TextView) findViewById(R.id.obfuscated_res_0x7f092434);
            this.f30211d = (TextView) findViewById(R.id.obfuscated_res_0x7f09242d);
            this.f30212e = (ImageView) findViewById(R.id.obfuscated_res_0x7f09243f);
            this.f30213f = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f092422);
            this.f30214g = findViewById(R.id.obfuscated_res_0x7f092426);
            this.f30215h = (TextView) findViewById(R.id.obfuscated_res_0x7f09243e);
            this.f30212e.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08080f, WebPManager.ResourceStateType.NORMAL));
            this.f30215h.setOnClickListener(this.w);
            this.f30213f.setLayoutManager(new d(this, this.a, 1, false));
            this.f30213f.setNestedScrollingEnabled(false);
            this.f30213f.setAdapter(this.x);
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
                this.f30210c.setText(this.k.getTitle());
            }
            setVoteSubContent(getSubContent());
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this);
            d2.n(R.string.J_X05);
            d2.f(this.s);
            if (this.s == R.color.CAM_X0207) {
                SkinManager.setBackgroundResource(this.f30214g, R.drawable.bg_vote_list_transmit_bottom);
            } else {
                SkinManager.setBackgroundResource(this.f30214g, R.drawable.bg_vote_list_bottom);
            }
            SkinManager.setViewTextColor(this.f30210c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f30211d, (int) R.color.CAM_X0109);
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
            eVar.f30223e.setVisibility(0);
            eVar.f30224f.setVisibility(8);
            eVar.a.setGravity(19);
            G(eVar, R.color.CAM_X0207, z2);
            if (z2) {
                SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0302);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.f30223e, R.drawable.obfuscated_res_0x7f080622, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
                return;
            }
            SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.f30223e, R.drawable.obfuscated_res_0x7f080615, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public final void E(e eVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{eVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            eVar.f30223e.setVisibility(8);
            eVar.f30224f.setVisibility(0);
            eVar.a.setGravity(19);
            int i = R.color.CAM_X0209;
            if (z2) {
                SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0302);
                SkinManager.setViewTextColor(eVar.f30224f, (int) R.color.CAM_X0302);
                if (z3) {
                    G(eVar, R.color.CAM_X0905, z2);
                    return;
                }
            } else {
                SkinManager.setViewTextColor(eVar.a, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(eVar.f30224f, (int) R.color.CAM_X0105);
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
            eVar.f30222d.setVisibility(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(B);
            gradientDrawable.setColor(SkinManager.getColor(i));
            eVar.f30221c.setBackgroundDrawable(gradientDrawable);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadii(C);
            gradientDrawable2.setColor(SkinManager.getColor(i2));
            eVar.f30220b.setBackgroundDrawable(gradientDrawable2);
            if (z2) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(eVar.a);
                d2.e(R.string.A_X07);
                d2.n(R.string.J_X04);
                d2.l(R.dimen.L_X01);
                d2.k(R.color.CAM_X0302);
                d2.f(i2);
                return;
            }
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(eVar.a);
            d3.n(R.string.J_X04);
            d3.l(R.dimen.L_X01);
            d3.k(R.color.CAM_X0902);
            d3.f(i2);
        }
    }

    public final void G(e eVar, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{eVar, Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            eVar.f30222d.setVisibility(8);
            if (z2) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(eVar.a);
                d2.e(R.string.A_X07);
                d2.n(R.string.J_X04);
                d2.l(R.dimen.L_X01);
                d2.k(R.color.CAM_X0302);
                d2.f(i);
                return;
            }
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(eVar.a);
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
            gradientDrawable.setColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.08f));
            this.f30215h.setBackgroundDrawable(gradientDrawable);
            if (!this.o && !ListUtils.isEmpty(this.m) && this.m.size() > 0) {
                SkinManager.setViewTextColor(this.f30215h, (int) R.color.CAM_X0302);
                this.f30215h.setEnabled(true);
                return;
            }
            this.f30215h.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.f30215h.setEnabled(false);
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
            this.f30213f.setLayoutParams(layoutParams);
            this.f30214g.setVisibility(0);
            this.f30215h.setVisibility(8);
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
        B(pollData, str, c.a.d.f.m.b.g(str2, 0L));
        List<PollOptionData> options = this.k.getOptions();
        if (ListUtils.isEmpty(options)) {
            return;
        }
        setViewWithAllData(options);
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) || (imageView = this.f30212e) == null || onClickListener == null) {
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
            this.f30209b = tbPageContext;
            this.u = new AddPollPostModel(tbPageContext);
        }
    }

    public void setVoteSubContent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f30211d.setText(str);
    }

    public void setVoteTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f30210c.setText(str);
    }

    public void setVoteViewDeleteVisibility(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || (imageView = this.f30212e) == null) {
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
