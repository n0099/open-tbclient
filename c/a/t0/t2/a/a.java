package c.a.t0.t2.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.b2;
import c.a.t0.s2.r.f;
import c.a.t0.s2.s.c;
import c.a.t0.s2.u.f.n;
import c.a.t0.s2.y.b;
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
/* loaded from: classes8.dex */
public class a extends n<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, c.a.t0.s2.u.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnLongClickListener A;
    public int B;
    public int C;
    public boolean D;
    public final boolean E;
    public int s;
    public boolean t;
    public boolean u;
    public f v;
    public boolean w;
    public View.OnClickListener x;
    public TbRichTextView.y y;
    public c z;

    /* renamed from: c.a.t0.t2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1437a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnClickListenerC1437a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.s = 0;
        this.t = true;
        this.u = true;
        this.v = null;
        this.w = true;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = false;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 14 && i4 <= 16) {
            z = true;
        }
        this.E = z;
        a0(pbFragment);
    }

    @Override // c.a.t0.s2.u.f.n, c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        f0(i2, view, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view;
    }

    @Override // c.a.t0.s2.u.f.n
    public void a0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            super.a0(bVar);
            if (bVar != null) {
                this.B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
                this.C = c.a.d.f.p.n.k(this.f3299e) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
            }
        }
    }

    public final void b0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, pbInterviewLiveNormalItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.u()) && this.t) {
                pbInterviewLiveNormalItemViewHolder.richText.setOnClickListener(this.x);
            } else {
                pbInterviewLiveNormalItemViewHolder.richText.setOnClickListener(null);
            }
            pbInterviewLiveNormalItemViewHolder.richText.setTextViewCheckSelection(false);
            pbInterviewLiveNormalItemViewHolder.richText.setTextViewOnClickListener(new View$OnClickListenerC1437a(this));
        }
    }

    @Override // c.a.t0.s2.u.c.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.t = z;
        }
    }

    public final void c0(TbRichTextView tbRichTextView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbRichTextView, i2) == null) || tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i2;
        tbRichTextView.getLayoutStrategy().q(this.C - (i2 - this.B));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    @Override // c.a.t0.s2.u.c.a
    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.A = onLongClickListener;
        }
    }

    public final void d0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        b2 m1;
        String str;
        String str2;
        long j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, pbInterviewLiveNormalItemViewHolder, postData) == null) || pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        c0(pbInterviewLiveNormalItemViewHolder.richText, (int) this.f3299e.getResources().getDimension(R.dimen.ds30));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.richText.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.richText.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.richText.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.richText.startLoad(null);
        postData.I0();
        if (postData.A() == 1) {
            pbInterviewLiveNormalItemViewHolder.giftListView.setVisibility(0);
            if (postData.t() != null) {
                long userIdLong = postData.t().getUserIdLong();
                String userName = postData.t().getUserName();
                str2 = postData.t().getName_show();
                str = userName;
                j2 = userIdLong;
            } else {
                str = null;
                str2 = null;
                j2 = 0;
            }
            pbInterviewLiveNormalItemViewHolder.giftListView.fillGiftData(postData.F(), str, str2, j2, c.a.d.f.m.b.g(this.v.O().g0(), 0L), c.a.d.f.m.b.g(postData.G(), 0L));
            pbInterviewLiveNormalItemViewHolder.giftListView.onChangeSkinType();
            if (this.w) {
                PraiseData M0 = this.v.O().M0();
                if (M0 != null && M0.getUser() != null && M0.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.praiseView.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.praiseToLine.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.praiseBottomLine.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.praiseView.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.praiseView.setData(M0, this.v.O().g0(), M0.getPostId(), true);
                    pbInterviewLiveNormalItemViewHolder.praiseView.onChangeSkin(this.p);
                } else {
                    pbInterviewLiveNormalItemViewHolder.praiseView.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.praiseToLine.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.praiseBottomLine.setVisibility(8);
                }
            } else {
                pbInterviewLiveNormalItemViewHolder.praiseView.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.praiseToLine.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.praiseBottomLine.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.praiseView.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.praiseToLine.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.praiseBottomLine.setVisibility(0);
            c0(pbInterviewLiveNormalItemViewHolder.richText, (int) this.f3299e.getResources().getDimension(R.dimen.ds30));
        } else {
            pbInterviewLiveNormalItemViewHolder.giftListView.setVisibility(8);
        }
        pbInterviewLiveNormalItemViewHolder.richText.getLayoutStrategy().x(R.drawable.pic_video);
        pbInterviewLiveNormalItemViewHolder.richText.setTextColor(SkinManager.getColor(R.color.common_color_10039));
        pbInterviewLiveNormalItemViewHolder.richText.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbInterviewLiveNormalItemViewHolder.richText.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.t) {
            pbInterviewLiveNormalItemViewHolder.richText.getLayoutStrategy().g(R.drawable.transparent_bg);
        } else {
            pbInterviewLiveNormalItemViewHolder.richText.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbInterviewLiveNormalItemViewHolder.richText.setIsFromCDN(this.q);
        TbRichText N = postData.N();
        if (!this.D && this.E) {
            pbInterviewLiveNormalItemViewHolder.richText.setText(N, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.richText.setText(N, false);
        }
        if (this.v.O().m1() != null) {
            pbInterviewLiveNormalItemViewHolder.mPostImage.startLoad(this.v.O().m1().i(), this.q ? 17 : 18, false);
            int k2 = c.a.d.f.p.n.k(this.f3299e);
            float h2 = m1.h() / m1.j();
            int i2 = (int) (h2 > 1.0f ? k2 * 1.0f : h2 < 0.2f ? k2 * 0.2f : k2 * h2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.mPostImage.getLayoutParams();
            layoutParams2.height = i2;
            layoutParams2.width = k2;
            pbInterviewLiveNormalItemViewHolder.mPostImage.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.mPostImage.setVisibility(8);
        }
        b0(pbInterviewLiveNormalItemViewHolder, postData);
    }

    @Override // c.a.t0.s2.u.c.a
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: e0 */
    public PbInterviewLiveNormalItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) ? new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.f3299e).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.u, this.t, this.s, false) : (PbInterviewLiveNormalItemViewHolder) invokeL.objValue;
    }

    @Override // c.a.t0.s2.u.c.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.w = z;
        }
    }

    public View f0(int i2, View view, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder})) == null) {
            super.S(i2, view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder);
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
            pbInterviewLiveNormalItemViewHolder.richText.setOnLongClickListener(this.A);
            pbInterviewLiveNormalItemViewHolder.richText.setOnTouchListener(this.z);
            pbInterviewLiveNormalItemViewHolder.richText.setOnImageClickListener(this.y);
            b bVar = this.m;
            if (bVar == null || bVar.getPbActivity() == null) {
                return;
            }
            pbInterviewLiveNormalItemViewHolder.richText.setOnEmotionClickListener(this.m.getPbActivity().mEvent.f23417e);
        }
    }

    @Override // c.a.t0.s2.u.c.a
    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
        }
    }

    @Override // c.a.t0.s2.u.c.a
    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.s = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
        }
    }

    @Override // c.a.t0.s2.u.c.a
    public void p(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, yVar) == null) {
            this.y = yVar;
        }
    }

    @Override // c.a.t0.s2.u.c.a
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // c.a.t0.s2.u.c.a
    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    @Override // c.a.t0.s2.u.c.a
    public void t(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.v = fVar;
        }
    }
}
