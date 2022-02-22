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
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
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
/* loaded from: classes11.dex */
public class VoteView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final float[] F;
    public static final float[] G;
    public static final float[] H;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public RecyclerView.Adapter<e> B;

    /* renamed from: e  reason: collision with root package name */
    public Context f40840e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f40841f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40842g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f40843h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f40844i;

    /* renamed from: j  reason: collision with root package name */
    public RecyclerView f40845j;
    public View k;
    public TextView l;
    public String m;
    public long n;
    public PollData o;
    public List<PollOptionData> p;
    public List<Integer> q;
    public View.OnClickListener r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public AddPollPostModel y;
    public AddPollPostModel.b z;

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voteView;
        }

        @Override // com.baidu.tieba.model.AddPollPostModel.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (i2 != 0) {
                    if (StringUtils.isNull(str)) {
                        return;
                    }
                    this.a.f40841f.showToast(str);
                    return;
                }
                this.a.l.setText(this.a.f40840e.getString(j.pb_voted_text));
                PollData pollData = this.a.o;
                VoteView voteView = this.a;
                pollData.setPolledValue(voteView.z(voteView.q));
                this.a.o.setIsPolled(1);
                VoteView voteView2 = this.a;
                voteView2.s = voteView2.o.getIsPolled() == 1;
                this.a.o.setTotalNum(this.a.o.getTotalNum() + 1);
                VoteView voteView3 = this.a;
                voteView3.setVoteSubContent(voteView3.getSubContent());
                this.a.o.setTotalPoll(this.a.o.getTotalPoll() + this.a.q.size());
                if (this.a.B != null) {
                    this.a.B.notifyDataSetChanged();
                }
                this.a.G();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoteView f40846e;

        public b(VoteView voteView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40846e = voteView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VoteView voteView = this.f40846e;
                String z = voteView.z(voteView.q);
                if (this.f40846e.f40841f == null || this.f40846e.y == null || StringUtils.isNull(this.f40846e.m) || this.f40846e.z == null || StringUtils.isNull(z) || this.f40846e.o == null) {
                    return;
                }
                this.f40846e.y.B(c.a.d.f.m.b.g(this.f40846e.m, -1L));
                this.f40846e.y.A(this.f40846e.z);
                this.f40846e.y.y(this.f40846e.m, z, this.f40846e.n);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c extends RecyclerView.Adapter<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f40847e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f40848f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f40849g;

            public a(c cVar, e eVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, eVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40849g = cVar;
                this.f40847e = eVar;
                this.f40848f = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    VoteView voteView = this.f40849g.a;
                    voteView.C(this.f40847e, !voteView.q.contains(Integer.valueOf(((PollOptionData) this.f40849g.a.p.get(this.f40848f)).getId())));
                    if (!this.f40849g.a.q.contains(Integer.valueOf(((PollOptionData) this.f40849g.a.p.get(this.f40848f)).getId()))) {
                        this.f40849g.a.q.add(Integer.valueOf(((PollOptionData) this.f40849g.a.p.get(this.f40848f)).getId()));
                        PollData pollData = this.f40849g.a.o;
                        VoteView voteView2 = this.f40849g.a;
                        pollData.setPolledValue(voteView2.z(voteView2.q));
                        ((PollOptionData) this.f40849g.a.p.get(this.f40848f)).setNum(((PollOptionData) this.f40849g.a.p.get(this.f40848f)).getNum() + 1);
                        this.f40849g.a.o.getOptions().get(this.f40848f).setNum(((PollOptionData) this.f40849g.a.p.get(this.f40848f)).getNum());
                    } else {
                        this.f40849g.a.q.remove(Integer.valueOf(((PollOptionData) this.f40849g.a.p.get(this.f40848f)).getId()));
                        PollData pollData2 = this.f40849g.a.o;
                        VoteView voteView3 = this.f40849g.a;
                        pollData2.setPolledValue(voteView3.z(voteView3.q));
                        ((PollOptionData) this.f40849g.a.p.get(this.f40848f)).setNum(((PollOptionData) this.f40849g.a.p.get(this.f40848f)).getNum() - 1);
                        this.f40849g.a.o.getOptions().get(this.f40848f).setNum(((PollOptionData) this.f40849g.a.p.get(this.f40848f)).getNum());
                    }
                    this.f40849g.a.G();
                }
            }
        }

        /* loaded from: classes11.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f40850e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f40851f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f40852g;

            public b(c cVar, int i2, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i2), eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40852g = cVar;
                this.f40850e = i2;
                this.f40851f = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f40852g.a.q.add(Integer.valueOf(((PollOptionData) this.f40852g.a.p.get(this.f40850e)).getId()));
                    PollData pollData = this.f40852g.a.o;
                    VoteView voteView = this.f40852g.a;
                    pollData.setPolledValue(voteView.z(voteView.q));
                    ((PollOptionData) this.f40852g.a.p.get(this.f40850e)).setNum(((PollOptionData) this.f40852g.a.p.get(this.f40850e)).getNum() + 1);
                    this.f40852g.a.o.getOptions().get(this.f40850e).setNum(((PollOptionData) this.f40852g.a.p.get(this.f40850e)).getNum());
                    if (this.f40852g.a.A != null) {
                        this.f40852g.a.A.onClick(this.f40851f.a);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voteView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, eVar, i2) == null) {
                if (this.a.o == null || this.a.o.getOptions() == null || this.a.p == null) {
                    this.a.setSingleUnCheckItemView(eVar);
                    if (this.a.r != null) {
                        eVar.a.setOnClickListener(this.a.r);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) this.a.p.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = this.a.o.getTotalPoll() == num;
                    boolean contains = this.a.q.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!this.a.s && !this.a.t) {
                        if (this.a.u) {
                            if (!this.a.v) {
                                this.a.C(eVar, false);
                            } else {
                                this.a.setSingleUnCheckItemView(eVar);
                            }
                            if ((!this.a.x && this.a.p.size() > 3) || this.a.v) {
                                eVar.a.setOnClickListener(this.a.r);
                            } else {
                                eVar.a.setOnClickListener(new a(this, eVar, i2));
                            }
                        } else {
                            this.a.setSingleUnCheckItemView(eVar);
                            if ((!this.a.x && this.a.p.size() > 3) || this.a.v) {
                                eVar.a.setOnClickListener(this.a.r);
                            } else {
                                eVar.a.setOnClickListener(new b(this, i2, eVar));
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (this.a.o.getTotalPoll() - num));
                        eVar.f40854c.setLayoutParams(layoutParams);
                        eVar.f40853b.setLayoutParams(layoutParams2);
                        this.a.D(eVar, contains, z2, z);
                        eVar.f40857f.setText(StringHelper.numberUniformFormatExtraWithRoundVote(num) + this.a.f40840e.getString(j.write_vote_num));
                        eVar.a.setOnClickListener(this.a.r);
                    }
                }
                eVar.a.setText(((PollOptionData) this.a.p.get(i2)).getText());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new e(this.a, LayoutInflater.from(this.a.f40840e).inflate(h.view_vote_text_item, viewGroup, false)) : (e) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a.p == null) {
                    return 0;
                }
                return this.a.p.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VoteView voteView, Context context, int i2, boolean z) {
            super(context, i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView, context, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes11.dex */
    public class e extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f40853b;

        /* renamed from: c  reason: collision with root package name */
        public View f40854c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f40855d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f40856e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f40857f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VoteView f40858g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VoteView voteView, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40858g = voteView;
            this.a = (TextView) view.findViewById(g.vote_item);
            this.f40853b = view.findViewById(g.vote_item_background);
            this.f40854c = view.findViewById(g.vote_item_foreground);
            this.f40855d = (LinearLayout) view.findViewById(g.vote_item_ground);
            this.f40856e = (ImageView) view.findViewById(g.vote_check);
            this.f40857f = (TextView) view.findViewById(g.vote_num);
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
        C = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds10);
        D = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds45);
        E = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds469);
        int i2 = C;
        F = new float[]{i2, i2, 0.0f, 0.0f, 0.0f, 0.0f, i2, i2};
        G = new float[]{0.0f, 0.0f, i2, i2, i2, i2, 0.0f, 0.0f};
        int i3 = D;
        H = new float[]{i3, i3, i3, i3, i3, i3, i3, i3};
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.o.getIsMulti() == 1) {
                context = this.f40840e;
                i2 = j.vote_type_multiple;
            } else {
                context = this.f40840e;
                i2 = j.vote_type_single;
            }
            String string = context.getString(i2);
            long endTime = this.o.getEndTime();
            if (endTime > 0) {
                Date date = new Date(endTime * 1000);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                str = String.format(this.f40840e.getString(j.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
            } else {
                str = "";
            }
            if (!StringUtils.isNull(str)) {
                string = string + " · " + str;
            }
            String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(this.o.getTotalNum());
            if (StringUtils.isNull(numberUniformFormatExtraWithRoundVote)) {
                return string;
            }
            return string + " · " + numberUniformFormatExtraWithRoundVote + this.f40840e.getString(j.write_vote_total);
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, eVar) == null) {
            eVar.f40856e.setVisibility(8);
            eVar.f40857f.setVisibility(8);
            eVar.a.setGravity(17);
            SkinManager.setViewTextColor(eVar.a, c.a.u0.a4.d.CAM_X0105);
            F(eVar, c.a.u0.a4.d.CAM_X0207, false);
        }
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, list) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = n.f(this.f40840e, c.a.u0.a4.e.tbds25);
            this.f40845j.setLayoutParams(layoutParams);
            this.k.setVisibility(8);
            if (this.u && !this.t && !this.s && !this.v) {
                this.l.setVisibility(0);
                this.l.setText(this.f40840e.getString(j.pb_vote_text));
            } else {
                this.l.setVisibility(8);
            }
            setData(list);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.f40840e).inflate(h.view_vote_main, (ViewGroup) this, true);
            this.f40842g = (TextView) findViewById(g.vote_title);
            this.f40843h = (TextView) findViewById(g.vote_sub_content);
            this.f40844i = (ImageView) findViewById(g.vote_view_delete);
            this.f40845j = (RecyclerView) findViewById(g.vote_item_list);
            this.k = findViewById(g.vote_list_bottom);
            this.l = (TextView) findViewById(g.vote_view_btn);
            this.f40844i.setImageDrawable(WebPManager.getMaskDrawable(f.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            this.l.setOnClickListener(this.A);
            this.f40845j.setLayoutManager(new d(this, this.f40840e, 1, false));
            this.f40845j.setNestedScrollingEnabled(false);
            this.f40845j.setAdapter(this.B);
            this.B.notifyDataSetChanged();
        }
    }

    public final void B(PollData pollData, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{pollData, str, Long.valueOf(j2)}) == null) {
            this.m = str;
            this.n = j2;
            this.o = pollData;
            this.s = pollData.getIsPolled() == 1;
            this.q.clear();
            if (this.s && !StringUtils.isNull(this.o.getPolledValue())) {
                for (String str2 : this.o.getPolledValue().split(",")) {
                    this.q.add(Integer.valueOf(Integer.parseInt(str2)));
                }
            }
            this.t = this.o.getLastTime() <= 0 && this.o.getLastTime() != -1;
            this.u = this.o.getIsMulti() == 1;
            if (!StringUtils.isNull(this.o.getTitle())) {
                this.f40842g.setText(this.o.getTitle());
            }
            setVoteSubContent(getSubContent());
        }
    }

    public final void C(e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, eVar, z) == null) {
            eVar.f40856e.setVisibility(0);
            eVar.f40857f.setVisibility(8);
            eVar.a.setGravity(19);
            F(eVar, c.a.u0.a4.d.CAM_X0207, z);
            if (z) {
                SkinManager.setViewTextColor(eVar.a, c.a.u0.a4.d.CAM_X0302);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.f40856e, f.ic_icon_pure_toast_complete24_svg, c.a.u0.a4.d.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
                return;
            }
            SkinManager.setViewTextColor(eVar.a, c.a.u0.a4.d.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.f40856e, f.ic_icon_pure_strok3_24_svg, c.a.u0.a4.d.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public final void D(e eVar, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{eVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            eVar.f40856e.setVisibility(8);
            eVar.f40857f.setVisibility(0);
            eVar.a.setGravity(19);
            if (z) {
                SkinManager.setViewTextColor(eVar.a, c.a.u0.a4.d.CAM_X0302);
                SkinManager.setViewTextColor(eVar.f40857f, c.a.u0.a4.d.CAM_X0302);
                if (z2) {
                    F(eVar, c.a.u0.a4.d.CAM_X0905, z);
                    return;
                }
            } else {
                SkinManager.setViewTextColor(eVar.a, c.a.u0.a4.d.CAM_X0105);
                SkinManager.setViewTextColor(eVar.f40857f, c.a.u0.a4.d.CAM_X0105);
                if (z3) {
                    F(eVar, c.a.u0.a4.d.CAM_X0207, z);
                    return;
                } else if (z2) {
                    F(eVar, c.a.u0.a4.d.CAM_X0209, z);
                    return;
                }
            }
            E(eVar, z ? c.a.u0.a4.d.CAM_X0905 : c.a.u0.a4.d.CAM_X0209, c.a.u0.a4.d.CAM_X0207, z);
        }
    }

    public final void E(e eVar, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            eVar.f40855d.setVisibility(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(F);
            gradientDrawable.setColor(SkinManager.getColor(i2));
            eVar.f40854c.setBackgroundDrawable(gradientDrawable);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadii(G);
            gradientDrawable2.setColor(SkinManager.getColor(i3));
            eVar.f40853b.setBackgroundDrawable(gradientDrawable2);
            if (z) {
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(eVar.a);
                d2.e(j.A_X07);
                d2.n(j.J_X04);
                d2.l(c.a.u0.a4.e.L_X01);
                d2.k(c.a.u0.a4.d.CAM_X0302);
                d2.f(i3);
                return;
            }
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(eVar.a);
            d3.n(j.J_X04);
            d3.l(c.a.u0.a4.e.L_X01);
            d3.k(c.a.u0.a4.d.CAM_X0902);
            d3.f(i3);
        }
    }

    public final void F(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            eVar.f40855d.setVisibility(8);
            if (z) {
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(eVar.a);
                d2.e(j.A_X07);
                d2.n(j.J_X04);
                d2.l(c.a.u0.a4.e.L_X01);
                d2.k(c.a.u0.a4.d.CAM_X0302);
                d2.f(i2);
                return;
            }
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(eVar.a);
            d3.n(j.J_X04);
            d3.l(c.a.u0.a4.e.L_X01);
            d3.k(c.a.u0.a4.d.CAM_X0902);
            d3.f(i2);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(H);
            gradientDrawable.setColor(c.a.u0.z3.c.a(SkinManager.getColor(c.a.u0.a4.d.CAM_X0302), 0.08f));
            this.l.setBackgroundDrawable(gradientDrawable);
            if (!this.s && !ListUtils.isEmpty(this.q) && this.q.size() > 0) {
                SkinManager.setViewTextColor(this.l, c.a.u0.a4.d.CAM_X0302);
                this.l.setEnabled(true);
                return;
            }
            this.l.setTextColor(c.a.u0.z3.c.a(SkinManager.getColor(c.a.u0.a4.d.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.l.setEnabled(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            AddPollPostModel addPollPostModel = this.y;
            if (addPollPostModel == null || this.s || this.t || this.v) {
                return;
            }
            addPollPostModel.registerListener();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this);
            d2.n(j.J_X05);
            d2.f(this.w);
            if (this.w == c.a.u0.a4.d.CAM_X0207) {
                SkinManager.setBackgroundResource(this.k, f.bg_vote_list_transmit_bottom);
            } else {
                SkinManager.setBackgroundResource(this.k, f.bg_vote_list_bottom);
            }
            SkinManager.setViewTextColor(this.f40842g, c.a.u0.a4.d.CAM_X0105);
            SkinManager.setViewTextColor(this.f40843h, c.a.u0.a4.d.CAM_X0109);
            G();
            RecyclerView.Adapter<e> adapter = this.B;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            AddPollPostModel addPollPostModel = this.y;
            if (addPollPostModel != null) {
                addPollPostModel.unRegisterListener();
            }
        }
    }

    public void setBgColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setData(PollData pollData, String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{pollData, str, Long.valueOf(j2)}) == null) || pollData == null) {
            return;
        }
        B(pollData, str, j2);
        List<PollOptionData> options = this.o.getOptions();
        if (ListUtils.isEmpty(options)) {
            return;
        }
        if (options.size() > 3) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, E);
            layoutParams.bottomMargin = 0;
            this.f40845j.setLayoutParams(layoutParams);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
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
        this.x = true;
        B(pollData, str, c.a.d.f.m.b.g(str2, 0L));
        List<PollOptionData> options = this.o.getOptions();
        if (ListUtils.isEmpty(options)) {
            return;
        }
        setViewWithAllData(options);
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) || (imageView = this.f40844i) == null || onClickListener == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setIsTransmit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.v = z;
        }
    }

    public void setMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i2;
            requestLayout();
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.r = onClickListener;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbPageContext) == null) {
            this.f40841f = tbPageContext;
            this.y = new AddPollPostModel(tbPageContext);
        }
    }

    public void setVoteSubContent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f40843h.setText(str);
    }

    public void setVoteTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f40842g.setText(str);
    }

    public void setVoteViewDeleteVisibility(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (imageView = this.f40844i) == null) {
            return;
        }
        imageView.setVisibility(i2);
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
        int i2 = 0;
        while (true) {
            int i3 = size - 1;
            if (i2 < i3) {
                sb.append(list.get(i2));
                sb.append(",");
                i2++;
            } else {
                sb.append(list.get(i3));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.w = c.a.u0.a4.d.CAM_X0206;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        this.f40840e = context;
        this.p = new ArrayList();
        this.q = new ArrayList();
        A();
    }

    public void setData(List<PollOptionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.p.clear();
            this.p.addAll(list);
            RecyclerView.Adapter<e> adapter = this.B;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
