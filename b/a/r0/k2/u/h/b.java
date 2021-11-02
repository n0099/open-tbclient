package b.a.r0.k2.u.h;

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
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
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
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f19604e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19605f;

    /* renamed from: g  reason: collision with root package name */
    public int f19606g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19607h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19608i;
    public boolean j;
    public d2 k;
    public boolean l;
    public boolean m;
    public String n;
    public int o;
    public View.OnLongClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19609a;

        /* renamed from: b  reason: collision with root package name */
        public View f19610b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19611c;

        /* renamed from: d  reason: collision with root package name */
        public View f19612d;

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
            this.f19609a = 3;
            this.f19612d = view;
            this.f19610b = view.findViewById(i.divider_line);
            TextView textView = (TextView) view.findViewById(i.center_reply_text);
            this.f19611c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != this.f19609a) {
                    SkinManager.setBackgroundColor(this.f19610b, f.CAM_X0109);
                    SkinManager.setViewTextColor(this.f19611c, f.CAM_X0109);
                    SkinManager.setBackgroundColor(this.f19611c, f.CAM_X0201);
                    this.f19611c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i2, h.icon_floor_arrow_n), (Drawable) null);
                }
                this.f19609a = i2;
            }
        }
    }

    /* renamed from: b.a.r0.k2.u.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0975b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19613a;

        /* renamed from: b  reason: collision with root package name */
        public View f19614b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f19615c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19616d;

        /* renamed from: e  reason: collision with root package name */
        public TbRichTextView f19617e;

        /* renamed from: f  reason: collision with root package name */
        public View f19618f;

        public C0975b() {
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
            this.f19613a = 3;
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
        this.f19604e = null;
        this.f19605f = null;
        this.f19606g = 0;
        this.f19607h = false;
        this.f19608i = false;
        this.j = true;
        this.l = false;
        this.m = false;
        this.n = "";
        this.o = -1;
        this.p = null;
        this.q = null;
        this.f19604e = context;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f19604e).inflate(j.new_sub_pb_list_expand_view, (ViewGroup) null);
            inflate.setTag(new a(this.f19604e, inflate));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            C0975b c0975b = new C0975b();
            View inflate = LayoutInflater.from(this.f19604e).inflate(j.new_sub_pb_list_item, (ViewGroup) null);
            c0975b.f19614b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(i.sub_pb_item_columnlayout);
            c0975b.f19615c = linearLayout;
            if (this.l) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = l.g(this.f19604e, g.ds8);
                layoutParams.bottomMargin = l.g(this.f19604e, g.ds8);
                c0975b.f19615c.setLayoutParams(layoutParams);
            }
            c0975b.f19616d = (TextView) inflate.findViewById(i.manage_btn);
            c0975b.f19617e = (TbRichTextView) inflate.findViewById(i.new_sub_pb_list_richText);
            c0975b.f19618f = inflate.findViewById(i.divide_bottom_view);
            c0975b.f19617e.getLayoutStrategy().t();
            if (!this.l) {
                c0975b.f19617e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                c0975b.f19617e.getLayoutStrategy().j(0);
                c0975b.f19617e.getLayoutStrategy().l(l.g(this.f19604e, g.tbds20));
                c0975b.f19617e.getLayoutStrategy().m(l.g(this.f19604e, g.tbds14));
                c0975b.f19617e.setMaxLines(4);
                c0975b.f19617e.setTextEllipsize(TextUtils.TruncateAt.END);
                c0975b.f19617e.setAddTruncateListener(true);
                c0975b.f19617e.setTextSize(TbConfig.getOutterSubpbContentSize());
            } else {
                c0975b.f19617e.setTextSize(TbConfig.getContentSizeOfLzl());
            }
            c0975b.f19617e.setSubPbPost(true);
            c0975b.f19617e.setTextColor(SkinManager.getColor(f.CAM_X0106));
            c0975b.f19617e.setIsNeedResizeEmotion(true);
            c0975b.f19617e.setTextCenter(true);
            c0975b.f19617e.setOnClickListener(this.q);
            c0975b.f19616d.setOnClickListener(this.f19605f);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(i.tag_holder, c0975b);
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
    public void c(C0975b c0975b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{c0975b, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || c0975b == null || postData == null) {
            return;
        }
        boolean z7 = true;
        boolean z8 = false;
        if (!postData.c0) {
            Context context = this.f19604e;
            if (context instanceof b.a.r0.k2.u.a) {
                b.a.r0.k2.u.a aVar = (b.a.r0.k2.u.a) context;
                postData.F0(aVar.getPageContext(), postData.t() != null && aVar.isHost(postData.t().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(c0975b.f19614b, f.CAM_X0204);
        } else {
            c0975b.f19614b.setBackgroundResource(0);
        }
        if (postData.d0()) {
            c0975b.f19618f.setVisibility(0);
        } else {
            c0975b.f19618f.setVisibility(8);
        }
        c0975b.f19617e.setPadding(0, 0, 0, 0);
        if (postData.t() != null) {
            String name_show = postData.t().getName_show();
            String userId = postData.t().getUserId();
            String portrait = postData.t().getPortrait();
            SparseArray sparseArray2 = (SparseArray) c0975b.f19614b.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                c0975b.f19614b.setTag(sparseArray2);
                c0975b.f19617e.setTag(sparseArray2);
            }
            sparseArray2.put(i.tag_photo_username, name_show);
            sparseArray2.put(i.tag_photo_userid, userId);
            sparseArray2.put(i.tag_photo_portrait, portrait);
            sparseArray2.put(i.tag_clip_board, postData);
            sparseArray2.put(i.tag_is_subpb, Boolean.TRUE);
        }
        c0975b.f19617e.setLinkTextColor(SkinManager.getColor(f.CAM_X0108));
        c0975b.f19617e.setTextColor(SkinManager.getColor(f.CAM_X0106));
        d(postData, this.l);
        TbRichText M = postData.M();
        if (M != null) {
            c0975b.f19617e.setVoiceViewRes(j.voice_play_btn_new);
            c0975b.f19617e.setIsFromCDN(this.j);
            if (c0975b.f19613a != TbadkCoreApplication.getInst().getSkinType()) {
                M.isChanged = true;
            }
            c0975b.f19617e.setText(M);
        }
        String userId2 = postData.t().getUserId();
        int i2 = this.f19606g;
        if (i2 != 0) {
            z4 = (i2 == 1002 || i2 == 3) ? false : true;
            z5 = (this.f19606g == 3 || this.k.Q1()) ? false : true;
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
        if (this.f19607h) {
            if (!this.k.Q1()) {
                z5 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = true;
                } else {
                    z7 = z5;
                }
                c0975b.f19616d.setVisibility(8);
                sparseArray = (SparseArray) c0975b.f19614b.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    c0975b.f19614b.setTag(sparseArray);
                    c0975b.f19617e.setTag(sparseArray);
                }
                sparseArray.put(i.tag_subpb_main_floor_post_id, this.n);
                if (!z4) {
                    sparseArray.put(i.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(i.tag_manage_user_identity, Integer.valueOf(this.f19606g));
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
                    if (this.k != null) {
                        sparseArray.put(i.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(i.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(i.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(i.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(i.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.k.f0() != null) {
                            sparseArray.put(i.tag_user_mute_thread_id, this.k.f0());
                        }
                        sparseArray.put(i.tag_user_mute_post_id, postData.G());
                    }
                } else {
                    sparseArray.put(i.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z7) {
                    sparseArray.put(i.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(i.tag_manage_user_identity, Integer.valueOf(this.f19606g));
                    sparseArray.put(i.tag_del_post_is_self, Boolean.valueOf(z8));
                    sparseArray.put(i.tag_del_post_type, 2);
                    sparseArray.put(i.tag_del_post_id, postData.G());
                    sparseArray.put(i.tag_has_sub_post, Boolean.valueOf(postData.a0()));
                } else {
                    sparseArray.put(i.tag_should_delete_visible, Boolean.FALSE);
                }
                if (this.l && z2 && this.m) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0975b.f19615c.getLayoutParams();
                    layoutParams.topMargin = l.g(this.f19604e, g.ds32);
                    layoutParams.bottomMargin = l.g(this.f19604e, g.ds8);
                    c0975b.f19615c.setLayoutParams(layoutParams);
                }
                if (this.l && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0975b.f19615c.getLayoutParams();
                    layoutParams2.topMargin = l.g(this.f19604e, g.ds8);
                    layoutParams2.bottomMargin = l.g(this.f19604e, g.ds8);
                    c0975b.f19615c.setLayoutParams(layoutParams2);
                }
                c0975b.f19616d.setTag(sparseArray);
                c0975b.f19617e.setTag(sparseArray);
                c0975b.f19613a = TbadkCoreApplication.getInst().getSkinType();
                c0975b.f19617e.setOnLongClickListener(this.p);
            }
        }
        z6 = false;
        if (userId2 == null) {
        }
        z7 = z5;
        c0975b.f19616d.setVisibility(8);
        sparseArray = (SparseArray) c0975b.f19614b.getTag();
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
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0975b.f19615c.getLayoutParams();
            layoutParams3.topMargin = l.g(this.f19604e, g.ds32);
            layoutParams3.bottomMargin = l.g(this.f19604e, g.ds8);
            c0975b.f19615c.setLayoutParams(layoutParams3);
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0975b.f19615c.getLayoutParams();
            layoutParams22.topMargin = l.g(this.f19604e, g.ds8);
            layoutParams22.bottomMargin = l.g(this.f19604e, g.ds8);
            c0975b.f19615c.setLayoutParams(layoutParams22);
        }
        c0975b.f19616d.setTag(sparseArray);
        c0975b.f19617e.setTag(sparseArray);
        c0975b.f19613a = TbadkCoreApplication.getInst().getSkinType();
        c0975b.f19617e.setOnLongClickListener(this.p);
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
            this.j = z;
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
        C0975b c0975b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            PostData postData = getItem(i2) instanceof PostData ? (PostData) getItem(i2) : null;
            if (view == null) {
                if (postData.getType() == PostData.D0) {
                    view = a();
                } else {
                    view = b();
                }
            }
            if ((view.getTag() instanceof a) && postData.getType() != PostData.D0) {
                view = b();
            }
            if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.D0) {
                view = a();
            }
            if ((view.getTag() instanceof SparseArray) && (c0975b = (C0975b) ((SparseArray) view.getTag()).get(i.tag_holder)) != null && postData != null) {
                boolean z = !this.f19608i && i2 + 1 >= getCount();
                boolean z2 = i2 == this.o;
                c(c0975b, postData, !z, i2 == 0, z2);
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
            this.f19605f = onClickListener;
        }
    }

    public void i(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, d2Var) == null) {
            this.k = d2Var;
        }
    }

    public void j(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f19606g = i2;
            this.f19607h = z;
        }
    }
}
