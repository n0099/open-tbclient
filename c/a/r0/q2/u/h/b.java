package c.a.r0.q2.u.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.q2.f;
import c.a.r0.q2.g;
import c.a.r0.q2.h;
import c.a.r0.q2.i;
import c.a.r0.q2.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f22288e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f22289f;

    /* renamed from: g  reason: collision with root package name */
    public int f22290g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22291h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22292i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22293j;

    /* renamed from: k  reason: collision with root package name */
    public d2 f22294k;
    public boolean l;
    public boolean m;
    public String n;
    public int o;
    public View.OnLongClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f22295b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f22296c;

        /* renamed from: d  reason: collision with root package name */
        public View f22297d;

        public a(Context context, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view};
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
            this.f22297d = view;
            this.f22295b = view.findViewById(i.divider_line);
            TextView textView = (TextView) view.findViewById(i.center_reply_text);
            this.f22296c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != this.a) {
                    SkinManager.setBackgroundColor(this.f22295b, f.CAM_X0109);
                    SkinManager.setViewTextColor(this.f22296c, f.CAM_X0109);
                    SkinManager.setBackgroundColor(this.f22296c, f.CAM_X0201);
                    this.f22296c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i2, h.icon_floor_arrow_n), (Drawable) null);
                }
                this.a = i2;
            }
        }
    }

    /* renamed from: c.a.r0.q2.u.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1291b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f22298b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f22299c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f22300d;

        /* renamed from: e  reason: collision with root package name */
        public TbRichTextView f22301e;

        /* renamed from: f  reason: collision with root package name */
        public View f22302f;

        public C1291b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22288e = null;
        this.f22289f = null;
        this.f22290g = 0;
        this.f22291h = false;
        this.f22292i = false;
        this.f22293j = true;
        this.l = false;
        this.m = false;
        this.n = "";
        this.o = -1;
        this.p = null;
        this.q = null;
        this.f22288e = context;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f22288e).inflate(j.new_sub_pb_list_expand_view, (ViewGroup) null);
            inflate.setTag(new a(this.f22288e, inflate));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            C1291b c1291b = new C1291b();
            View inflate = LayoutInflater.from(this.f22288e).inflate(j.new_sub_pb_list_item, (ViewGroup) null);
            c1291b.f22298b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(i.sub_pb_item_columnlayout);
            c1291b.f22299c = linearLayout;
            if (this.l) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = l.f(this.f22288e, g.ds8);
                layoutParams.bottomMargin = l.f(this.f22288e, g.ds8);
                c1291b.f22299c.setLayoutParams(layoutParams);
            }
            c1291b.f22300d = (TextView) inflate.findViewById(i.manage_btn);
            c1291b.f22301e = (TbRichTextView) inflate.findViewById(i.new_sub_pb_list_richText);
            c1291b.f22302f = inflate.findViewById(i.divide_bottom_view);
            c1291b.f22301e.getLayoutStrategy().t();
            if (!this.l) {
                c1291b.f22301e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                c1291b.f22301e.getLayoutStrategy().j(0);
                c1291b.f22301e.getLayoutStrategy().l(l.f(this.f22288e, g.tbds20));
                c1291b.f22301e.getLayoutStrategy().m(l.f(this.f22288e, g.tbds14));
                c1291b.f22301e.setMaxLines(4);
                c1291b.f22301e.setTextEllipsize(TextUtils.TruncateAt.END);
                c1291b.f22301e.setAddTruncateListener(true);
                c1291b.f22301e.setTextSize(TbConfig.getOutterSubpbContentSize());
            } else {
                c1291b.f22301e.setTextSize(TbConfig.getContentSizeOfLzl());
            }
            c1291b.f22301e.setSubPbPost(true);
            c1291b.f22301e.setTextColor(SkinManager.getColor(f.CAM_X0106));
            c1291b.f22301e.setIsNeedResizeEmotion(true);
            c1291b.f22301e.setTextCenter(true);
            c1291b.f22301e.setOnClickListener(this.q);
            c1291b.f22300d.setOnClickListener(this.f22289f);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(i.tag_holder, c1291b);
            inflate.setTag(sparseArray);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(C1291b c1291b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{c1291b, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || c1291b == null || postData == null) {
            return;
        }
        boolean z7 = true;
        boolean z8 = false;
        if (!postData.c0) {
            Context context = this.f22288e;
            if (context instanceof c.a.r0.q2.u.a) {
                c.a.r0.q2.u.a aVar = (c.a.r0.q2.u.a) context;
                postData.F0(aVar.getPageContext(), postData.t() != null && aVar.isHost(postData.t().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(c1291b.f22298b, f.CAM_X0204);
        } else {
            c1291b.f22298b.setBackgroundResource(0);
        }
        if (postData.d0()) {
            c1291b.f22302f.setVisibility(0);
        } else {
            c1291b.f22302f.setVisibility(8);
        }
        c1291b.f22301e.setPadding(0, 0, 0, 0);
        if (postData.t() != null) {
            String name_show = postData.t().getName_show();
            String userId = postData.t().getUserId();
            String portrait = postData.t().getPortrait();
            SparseArray sparseArray2 = (SparseArray) c1291b.f22298b.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                c1291b.f22298b.setTag(sparseArray2);
                c1291b.f22301e.setTag(sparseArray2);
            }
            sparseArray2.put(i.tag_photo_username, name_show);
            sparseArray2.put(i.tag_photo_userid, userId);
            sparseArray2.put(i.tag_photo_portrait, portrait);
            sparseArray2.put(i.tag_clip_board, postData);
            sparseArray2.put(i.tag_is_subpb, Boolean.TRUE);
        }
        c1291b.f22301e.setLinkTextColor(SkinManager.getColor(f.CAM_X0108));
        c1291b.f22301e.setTextColor(SkinManager.getColor(f.CAM_X0106));
        d(postData, this.l);
        TbRichText M = postData.M();
        if (M != null) {
            c1291b.f22301e.setVoiceViewRes(j.voice_play_btn_new);
            c1291b.f22301e.setIsFromCDN(this.f22293j);
            if (c1291b.a != TbadkCoreApplication.getInst().getSkinType()) {
                M.isChanged = true;
            }
            c1291b.f22301e.setText(M);
        }
        String userId2 = postData.t().getUserId();
        int i2 = this.f22290g;
        if (i2 != 0) {
            z4 = (i2 == 1002 || i2 == 3) ? false : true;
            z5 = (this.f22290g == 3 || this.f22294k.T1()) ? false : true;
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z4 = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z4 = false;
            }
        } else {
            z4 = false;
            z5 = false;
        }
        if (this.f22291h) {
            if (!this.f22294k.T1()) {
                z5 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = true;
                } else {
                    z7 = z5;
                }
                c1291b.f22300d.setVisibility(8);
                sparseArray = (SparseArray) c1291b.f22298b.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    c1291b.f22298b.setTag(sparseArray);
                    c1291b.f22301e.setTag(sparseArray);
                }
                sparseArray.put(i.tag_subpb_main_floor_post_id, this.n);
                if (!z4) {
                    sparseArray.put(i.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(i.tag_manage_user_identity, Integer.valueOf(this.f22290g));
                    if (postData.t() != null) {
                        sparseArray.put(i.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(i.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(i.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                    sparseArray.put(i.tag_forbid_user_post_id, postData.G());
                } else {
                    sparseArray.put(i.tag_should_manage_visible, Boolean.FALSE);
                }
                sparseArray.put(i.tag_forbid_user_post_id, postData.G());
                sparseArray.put(i.tag_clip_board, postData);
                if (!z6) {
                    if (this.f22294k != null) {
                        sparseArray.put(i.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(i.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(i.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(i.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(i.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.f22294k.g0() != null) {
                            sparseArray.put(i.tag_user_mute_thread_id, this.f22294k.g0());
                        }
                        sparseArray.put(i.tag_user_mute_post_id, postData.G());
                    }
                } else {
                    sparseArray.put(i.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z7) {
                    sparseArray.put(i.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(i.tag_manage_user_identity, Integer.valueOf(this.f22290g));
                    sparseArray.put(i.tag_del_post_is_self, Boolean.valueOf(z8));
                    sparseArray.put(i.tag_del_post_type, 2);
                    sparseArray.put(i.tag_del_post_id, postData.G());
                    sparseArray.put(i.tag_has_sub_post, Boolean.valueOf(postData.a0()));
                } else {
                    sparseArray.put(i.tag_should_delete_visible, Boolean.FALSE);
                }
                if (this.l && z2 && this.m) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1291b.f22299c.getLayoutParams();
                    layoutParams.topMargin = l.f(this.f22288e, g.ds32);
                    layoutParams.bottomMargin = l.f(this.f22288e, g.ds8);
                    c1291b.f22299c.setLayoutParams(layoutParams);
                }
                if (this.l && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c1291b.f22299c.getLayoutParams();
                    layoutParams2.topMargin = l.f(this.f22288e, g.ds8);
                    layoutParams2.bottomMargin = l.f(this.f22288e, g.ds8);
                    c1291b.f22299c.setLayoutParams(layoutParams2);
                }
                c1291b.f22300d.setTag(sparseArray);
                c1291b.f22301e.setTag(sparseArray);
                c1291b.a = TbadkCoreApplication.getInst().getSkinType();
                c1291b.f22301e.setOnLongClickListener(this.p);
            }
        }
        z6 = false;
        if (userId2 == null) {
        }
        z7 = z5;
        c1291b.f22300d.setVisibility(8);
        sparseArray = (SparseArray) c1291b.f22298b.getTag();
        if (sparseArray == null) {
        }
        sparseArray.put(i.tag_subpb_main_floor_post_id, this.n);
        if (!z4) {
        }
        sparseArray.put(i.tag_forbid_user_post_id, postData.G());
        sparseArray.put(i.tag_clip_board, postData);
        if (!z6) {
        }
        if (!z7) {
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c1291b.f22299c.getLayoutParams();
            layoutParams3.topMargin = l.f(this.f22288e, g.ds32);
            layoutParams3.bottomMargin = l.f(this.f22288e, g.ds8);
            c1291b.f22299c.setLayoutParams(layoutParams3);
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c1291b.f22299c.getLayoutParams();
            layoutParams22.topMargin = l.f(this.f22288e, g.ds8);
            layoutParams22.bottomMargin = l.f(this.f22288e, g.ds8);
            c1291b.f22299c.setLayoutParams(layoutParams22);
        }
        c1291b.f22300d.setTag(sparseArray);
        c1291b.f22301e.setTag(sparseArray);
        c1291b.a = TbadkCoreApplication.getInst().getSkinType();
        c1291b.f22301e.setOnLongClickListener(this.p);
    }

    public final void d(PostData postData, boolean z) {
        TbRichText M;
        SpannableStringBuilder G;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, postData, z) == null) || postData == null || (M = postData.M()) == null) {
            return;
        }
        ArrayList<TbRichTextData> y = M.y();
        if (ListUtils.isEmpty(y)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = y.get(y.size() - 1);
            int type = tbRichTextData != null ? tbRichTextData.getType() : -1;
            if (type == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.U());
                if (y.size() > 1) {
                    if ((y.get(y.size() + (-2)) != null ? y.get(y.size() - 2).getType() : -1) != type) {
                        str2 = StringHelper.getFormatTime(postData.U());
                    }
                }
                SpannableStringBuilder G2 = tbRichTextData.G();
                if (M.hasAppendTime && G2 != 0 && M.appendLength <= G2.length()) {
                    G2.delete(G2.length() - M.appendLength, G2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (G2 != null) {
                    G2.append((CharSequence) str);
                }
                M.hasAppendTime = true;
                M.appendLength = str.length();
            } else if (M.hasAppendTime) {
                str = "";
            } else {
                String formatTime = StringHelper.getFormatTime(postData.U());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.x(forceLToR);
                M.hasAppendTime = true;
                M.appendLength = forceLToR.length();
                y.add(tbRichTextData);
                str = forceLToR;
            }
            SpannableStringBuilder G3 = tbRichTextData.G();
            if (G3 == null || str.length() > G3.length()) {
                return;
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(f.CAM_X0109));
            G3.setSpan(absoluteSizeSpan, G3.length() - str.length(), G3.length(), 33);
            G3.setSpan(foregroundColorSpan, G3.length() - str.length(), G3.length(), 33);
            return;
        }
        TbRichTextData tbRichTextData2 = y.get(y.size() - 1);
        if (M.hasAppendTime && tbRichTextData2 != null && (G = tbRichTextData2.G()) != null && M.appendLength <= G.length()) {
            G.delete(G.length() - M.appendLength, G.length());
        }
        M.hasAppendTime = false;
        M.appendLength = 0;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f22293j = z;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.n = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1291b c1291b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            PostData postData = getItem(i2) instanceof PostData ? (PostData) getItem(i2) : null;
            if (view == null) {
                if (postData.getType() == PostData.E0) {
                    view = a();
                } else {
                    view = b();
                }
            }
            if ((view.getTag() instanceof a) && postData.getType() != PostData.E0) {
                view = b();
            }
            if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.E0) {
                view = a();
            }
            if ((view.getTag() instanceof SparseArray) && (c1291b = (C1291b) ((SparseArray) view.getTag()).get(i.tag_holder)) != null && postData != null) {
                boolean z = !this.f22292i && i2 + 1 >= getCount();
                boolean z2 = i2 == this.o;
                c(c1291b, postData, !z, i2 == 0, z2);
                if (z2) {
                    this.o = -1;
                }
            }
            if (view.getTag() instanceof a) {
                ((a) view.getTag()).a(TbadkCoreApplication.getInst().getSkinType());
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.f22289f = onClickListener;
        }
    }

    public void i(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, d2Var) == null) {
            this.f22294k = d2Var;
        }
    }

    public void j(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f22290g = i2;
            this.f22291h = z;
        }
    }
}
