package c.a.p0.x2.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.b;
import c.a.d.f.p.n;
import c.a.o0.r.r.z1;
import c.a.p0.w2.i.f;
import c.a.p0.w2.j.c;
import c.a.p0.w2.m.f.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pbextra.adapter.PbInterviewLiveNormalItemViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends r<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, c.a.p0.w2.m.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean A;
    public int o;
    public boolean p;
    public boolean q;
    public f r;
    public boolean s;
    public View.OnClickListener t;
    public TbRichTextView.y u;
    public c v;
    public View.OnLongClickListener w;
    public int x;
    public int y;
    public boolean z;

    /* renamed from: c.a.p0.x2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1546a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnClickListenerC1546a(a aVar) {
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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.w2.q.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.o = 0;
        this.p = true;
        this.q = true;
        this.r = null;
        this.s = true;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.z = false;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 14 && i3 <= 16) {
            z = true;
        }
        this.A = z;
        a0(pbFragment);
    }

    @Override // c.a.p0.w2.m.f.r, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        f0(i, view, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view;
    }

    @Override // c.a.p0.w2.m.f.r
    public void a0(c.a.p0.w2.q.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.a0(cVar);
            if (cVar != null) {
                this.x = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201);
                this.y = n.k(this.a) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253);
            }
        }
    }

    public final void b0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, pbInterviewLiveNormalItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.u()) && this.p) {
                pbInterviewLiveNormalItemViewHolder.f35304b.setOnClickListener(this.t);
            } else {
                pbInterviewLiveNormalItemViewHolder.f35304b.setOnClickListener(null);
            }
            pbInterviewLiveNormalItemViewHolder.f35304b.setTextViewCheckSelection(false);
            pbInterviewLiveNormalItemViewHolder.f35304b.setTextViewOnClickListener(new View$OnClickListenerC1546a(this));
        }
    }

    @Override // c.a.p0.w2.m.c.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.p = z;
        }
    }

    public final void c0(TbRichTextView tbRichTextView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbRichTextView, i) == null) || tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i;
        tbRichTextView.getLayoutStrategy().q(this.y - (i - this.x));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    @Override // c.a.p0.w2.m.c.a
    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.w = onLongClickListener;
        }
    }

    public final void d0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        z1 taskInfoData;
        String str;
        String str2;
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, pbInterviewLiveNormalItemViewHolder, postData) == null) || pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        c0(pbInterviewLiveNormalItemViewHolder.f35304b, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.f35304b.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.f35304b.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.f35304b.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.f35304b.k0(null);
        postData.I0();
        if (postData.A() == 1) {
            pbInterviewLiveNormalItemViewHolder.f35306d.setVisibility(0);
            if (postData.s() != null) {
                long userIdLong = postData.s().getUserIdLong();
                String userName = postData.s().getUserName();
                str2 = postData.s().getName_show();
                str = userName;
                j = userIdLong;
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            pbInterviewLiveNormalItemViewHolder.f35306d.g(postData.F(), str, str2, j, b.g(this.r.O().getId(), 0L), b.g(postData.G(), 0L));
            pbInterviewLiveNormalItemViewHolder.f35306d.i();
            if (this.s) {
                PraiseData praise = this.r.O().getPraise();
                if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.f35307e.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f35305c.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f35308f.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f35307e.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.f35307e.setData(praise, this.r.O().getId(), praise.getPostId(), true);
                    pbInterviewLiveNormalItemViewHolder.f35307e.i(this.l);
                } else {
                    pbInterviewLiveNormalItemViewHolder.f35307e.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f35305c.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f35308f.setVisibility(8);
                }
            } else {
                pbInterviewLiveNormalItemViewHolder.f35307e.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.f35305c.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.f35308f.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.f35307e.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.f35305c.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.f35308f.setVisibility(0);
            c0(pbInterviewLiveNormalItemViewHolder.f35304b, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
        } else {
            pbInterviewLiveNormalItemViewHolder.f35306d.setVisibility(8);
        }
        pbInterviewLiveNormalItemViewHolder.f35304b.getLayoutStrategy().x(R.drawable.pic_video);
        pbInterviewLiveNormalItemViewHolder.f35304b.setTextColor(SkinManager.getColor(R.color.common_color_10039));
        pbInterviewLiveNormalItemViewHolder.f35304b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbInterviewLiveNormalItemViewHolder.f35304b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.p) {
            pbInterviewLiveNormalItemViewHolder.f35304b.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081200);
        } else {
            pbInterviewLiveNormalItemViewHolder.f35304b.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbInterviewLiveNormalItemViewHolder.f35304b.setIsFromCDN(this.m);
        TbRichText N = postData.N();
        if (!this.z && this.A) {
            pbInterviewLiveNormalItemViewHolder.f35304b.setText(N, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.f35304b.setText(N, false);
        }
        if (this.r.O().getTaskInfoData() != null) {
            pbInterviewLiveNormalItemViewHolder.a.J(this.r.O().getTaskInfoData().i(), this.m ? 17 : 18, false);
            int k = n.k(this.a);
            float h2 = taskInfoData.h() / taskInfoData.j();
            int i = (int) (h2 > 1.0f ? k * 1.0f : h2 < 0.2f ? k * 0.2f : k * h2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.a.getLayoutParams();
            layoutParams2.height = i;
            layoutParams2.width = k;
            pbInterviewLiveNormalItemViewHolder.a.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.a.setVisibility(8);
        }
        b0(pbInterviewLiveNormalItemViewHolder, postData);
    }

    @Override // c.a.p0.w2.m.c.a
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public PbInterviewLiveNormalItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) ? new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0688, viewGroup, false), this.q, this.p, this.o, false) : (PbInterviewLiveNormalItemViewHolder) invokeL.objValue;
    }

    @Override // c.a.p0.w2.m.c.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    public View f0(int i, View view, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder})) == null) {
            super.S(i, view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder);
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            g0(pbInterviewLiveNormalItemViewHolder);
            d0(pbInterviewLiveNormalItemViewHolder, postData);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void g0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pbInterviewLiveNormalItemViewHolder) == null) {
            pbInterviewLiveNormalItemViewHolder.f35304b.setOnLongClickListener(this.w);
            pbInterviewLiveNormalItemViewHolder.f35304b.setOnTouchListener(this.v);
            pbInterviewLiveNormalItemViewHolder.f35304b.setOnImageClickListener(this.u);
            c.a.p0.w2.q.c cVar = this.i;
            if (cVar == null || cVar.x() == null) {
                return;
            }
            pbInterviewLiveNormalItemViewHolder.f35304b.setOnEmotionClickListener(this.i.x().mEvent.f20183e);
        }
    }

    @Override // c.a.p0.w2.m.c.a
    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
        }
    }

    @Override // c.a.p0.w2.m.c.a
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.o = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
        }
    }

    @Override // c.a.p0.w2.m.c.a
    public void p(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, yVar) == null) {
            this.u = yVar;
        }
    }

    @Override // c.a.p0.w2.m.c.a
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // c.a.p0.w2.m.c.a
    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    @Override // c.a.p0.w2.m.c.a
    public void t(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.r = fVar;
        }
    }
}
