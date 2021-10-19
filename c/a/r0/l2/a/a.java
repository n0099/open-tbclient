package c.a.r0.l2.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.q.b2;
import c.a.r0.k2.h.e;
import c.a.r0.k2.i.c;
import c.a.r0.k2.k.e.n;
import c.a.r0.k2.o.b;
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
public class a extends n<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, c.a.r0.k2.k.c.a {
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
    public e v;
    public boolean w;
    public View.OnClickListener x;
    public TbRichTextView.z y;
    public c z;

    /* renamed from: c.a.r0.l2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1025a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnClickListenerC1025a(a aVar) {
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
        i0(pbFragment);
    }

    @Override // c.a.r0.k2.k.e.n, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        n0(i2, view, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view;
    }

    @Override // c.a.r0.k2.k.c.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.t = z;
        }
    }

    @Override // c.a.r0.k2.k.c.a
    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) {
            this.A = onLongClickListener;
        }
    }

    @Override // c.a.r0.k2.k.c.a
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    @Override // c.a.r0.k2.k.c.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.w = z;
        }
    }

    @Override // c.a.r0.k2.k.e.n
    public void i0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            super.i0(bVar);
            if (bVar != null) {
                this.B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
                this.C = l.k(this.f2958e) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
            }
        }
    }

    public final void j0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pbInterviewLiveNormalItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.u()) && this.t) {
                pbInterviewLiveNormalItemViewHolder.richText.setOnClickListener(this.x);
            } else {
                pbInterviewLiveNormalItemViewHolder.richText.setOnClickListener(null);
            }
            pbInterviewLiveNormalItemViewHolder.richText.setTextViewCheckSelection(false);
            pbInterviewLiveNormalItemViewHolder.richText.setTextViewOnClickListener(new View$OnClickListenerC1025a(this));
        }
    }

    public final void k0(TbRichTextView tbRichTextView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichTextView, i2) == null) || tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i2;
        tbRichTextView.getLayoutStrategy().q(this.C - (i2 - this.B));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    public final void l0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        b2 j1;
        String str;
        String str2;
        long j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pbInterviewLiveNormalItemViewHolder, postData) == null) || pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        k0(pbInterviewLiveNormalItemViewHolder.richText, (int) this.f2958e.getResources().getDimension(R.dimen.ds30));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.richText.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.richText.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.richText.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.richText.startLoad(null);
        postData.D0();
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
            pbInterviewLiveNormalItemViewHolder.giftListView.fillGiftData(postData.D(), str, str2, j2, c.a.e.e.m.b.g(this.v.O().f0(), 0L), c.a.e.e.m.b.g(postData.E(), 0L));
            pbInterviewLiveNormalItemViewHolder.giftListView.onChangeSkinType();
            if (this.w) {
                PraiseData L0 = this.v.O().L0();
                if (L0 != null && L0.getUser() != null && L0.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.praiseView.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.praiseToLine.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.praiseBottomLine.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.praiseView.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.praiseView.setData(L0, this.v.O().f0(), L0.getPostId(), true);
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
            k0(pbInterviewLiveNormalItemViewHolder.richText, (int) this.f2958e.getResources().getDimension(R.dimen.ds30));
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
        TbRichText K = postData.K();
        if (!this.D && this.E) {
            pbInterviewLiveNormalItemViewHolder.richText.setText(K, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.richText.setText(K, false);
        }
        if (this.v.O().j1() != null) {
            pbInterviewLiveNormalItemViewHolder.mPostImage.startLoad(this.v.O().j1().i(), this.q ? 17 : 18, false);
            int k = l.k(this.f2958e);
            float h2 = j1.h() / j1.j();
            int i2 = (int) (h2 > 1.0f ? k * 1.0f : h2 < 0.2f ? k * 0.2f : k * h2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.mPostImage.getLayoutParams();
            layoutParams2.height = i2;
            layoutParams2.width = k;
            pbInterviewLiveNormalItemViewHolder.mPostImage.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.mPostImage.setVisibility(8);
        }
        j0(pbInterviewLiveNormalItemViewHolder, postData);
    }

    @Override // c.a.r0.k2.k.c.a
    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: m0 */
    public PbInterviewLiveNormalItemViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) ? new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.f2958e).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.u, this.t, this.s, false) : (PbInterviewLiveNormalItemViewHolder) invokeL.objValue;
    }

    @Override // c.a.r0.k2.k.c.a
    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.s = i2;
        }
    }

    public View n0(int i2, View view, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder})) == null) {
            super.a0(i2, view, viewGroup, postData, pbInterviewLiveNormalItemViewHolder);
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            o0(pbInterviewLiveNormalItemViewHolder);
            l0(pbInterviewLiveNormalItemViewHolder, postData);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void o0(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pbInterviewLiveNormalItemViewHolder) == null) {
            pbInterviewLiveNormalItemViewHolder.richText.setOnLongClickListener(this.A);
            pbInterviewLiveNormalItemViewHolder.richText.setOnTouchListener(this.z);
            pbInterviewLiveNormalItemViewHolder.richText.setOnImageClickListener(this.y);
            b bVar = this.m;
            if (bVar == null || bVar.getPbActivity() == null) {
                return;
            }
            pbInterviewLiveNormalItemViewHolder.richText.setOnEmotionClickListener(this.m.getPbActivity().mEvent.f20140e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
        }
    }

    @Override // c.a.r0.k2.k.c.a
    public void p(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zVar) == null) {
            this.y = zVar;
        }
    }

    @Override // c.a.r0.k2.k.c.a
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // c.a.r0.k2.k.c.a
    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    @Override // c.a.r0.k2.k.c.a
    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.v = eVar;
        }
    }
}
