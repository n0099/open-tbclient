package c.a.r0.j2.k.g;

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
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20427e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20428f;

    /* renamed from: g  reason: collision with root package name */
    public int f20429g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20430h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20431i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20432j;
    public d2 k;
    public boolean l;
    public boolean m;
    public String n;
    public int o;
    public View.OnLongClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f20433a;

        /* renamed from: b  reason: collision with root package name */
        public View f20434b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20435c;

        /* renamed from: d  reason: collision with root package name */
        public View f20436d;

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
            this.f20433a = 3;
            this.f20436d = view;
            this.f20434b = view.findViewById(R.id.divider_line);
            TextView textView = (TextView) view.findViewById(R.id.center_reply_text);
            this.f20435c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != this.f20433a) {
                    SkinManager.setBackgroundColor(this.f20434b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(this.f20435c, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(this.f20435c, R.color.CAM_X0201);
                    this.f20435c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i2, R.drawable.icon_floor_arrow_n), (Drawable) null);
                }
                this.f20433a = i2;
            }
        }
    }

    /* renamed from: c.a.r0.j2.k.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0969b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f20437a;

        /* renamed from: b  reason: collision with root package name */
        public View f20438b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f20439c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f20440d;

        /* renamed from: e  reason: collision with root package name */
        public TbRichTextView f20441e;

        /* renamed from: f  reason: collision with root package name */
        public View f20442f;

        public C0969b() {
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
            this.f20437a = 3;
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
        this.f20427e = null;
        this.f20428f = null;
        this.f20429g = 0;
        this.f20430h = false;
        this.f20431i = false;
        this.f20432j = true;
        this.l = false;
        this.m = false;
        this.n = "";
        this.o = -1;
        this.p = null;
        this.q = null;
        this.f20427e = context;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f20427e).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
            inflate.setTag(new a(this.f20427e, inflate));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            C0969b c0969b = new C0969b();
            View inflate = LayoutInflater.from(this.f20427e).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
            c0969b.f20438b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
            c0969b.f20439c = linearLayout;
            if (this.l) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = l.g(this.f20427e, R.dimen.ds8);
                layoutParams.bottomMargin = l.g(this.f20427e, R.dimen.ds8);
                c0969b.f20439c.setLayoutParams(layoutParams);
            }
            c0969b.f20440d = (TextView) inflate.findViewById(R.id.manage_btn);
            c0969b.f20441e = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
            c0969b.f20442f = inflate.findViewById(R.id.divide_bottom_view);
            c0969b.f20441e.getLayoutStrategy().t();
            if (!this.l) {
                c0969b.f20441e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                c0969b.f20441e.getLayoutStrategy().j(0);
                c0969b.f20441e.getLayoutStrategy().l(l.g(this.f20427e, R.dimen.tbds20));
                c0969b.f20441e.getLayoutStrategy().m(l.g(this.f20427e, R.dimen.tbds14));
                c0969b.f20441e.setMaxLines(4);
                c0969b.f20441e.setTextEllipsize(TextUtils.TruncateAt.END);
                c0969b.f20441e.setAddTruncateListener(true);
            }
            c0969b.f20441e.setSubPbPost(true);
            c0969b.f20441e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            c0969b.f20441e.setIsNeedResizeEmotion(true);
            c0969b.f20441e.setTextSize(TbConfig.getContentSizeOfLzl());
            c0969b.f20441e.setTextCenter(true);
            c0969b.f20441e.setOnClickListener(this.q);
            c0969b.f20440d.setOnClickListener(this.f20428f);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_holder, c0969b);
            inflate.setTag(sparseArray);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0240  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(C0969b c0969b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{c0969b, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || c0969b == null || postData == null) {
            return;
        }
        boolean z7 = true;
        boolean z8 = false;
        if (!postData.a0) {
            Context context = this.f20427e;
            if (context instanceof c.a.r0.j2.k.a) {
                c.a.r0.j2.k.a aVar = (c.a.r0.j2.k.a) context;
                postData.z0(aVar.getPageContext(), postData.t() != null && aVar.isHost(postData.t().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(c0969b.f20438b, R.color.CAM_X0204);
        } else {
            c0969b.f20438b.setBackgroundResource(0);
        }
        if (postData.Z()) {
            c0969b.f20442f.setVisibility(0);
        } else {
            c0969b.f20442f.setVisibility(8);
        }
        c0969b.f20441e.setPadding(0, 0, 0, 0);
        if (postData.t() != null) {
            String name_show = postData.t().getName_show();
            String userId = postData.t().getUserId();
            SparseArray sparseArray2 = (SparseArray) c0969b.f20438b.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                c0969b.f20438b.setTag(sparseArray2);
                c0969b.f20441e.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_photo_username, name_show);
            sparseArray2.put(R.id.tag_photo_userid, userId);
            sparseArray2.put(R.id.tag_clip_board, postData);
            sparseArray2.put(R.id.tag_is_subpb, Boolean.TRUE);
        }
        c0969b.f20441e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
        c0969b.f20441e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        d(postData, this.l);
        TbRichText K = postData.K();
        if (K != null) {
            c0969b.f20441e.setVoiceViewRes(R.layout.voice_play_btn_new);
            c0969b.f20441e.setIsFromCDN(this.f20432j);
            if (c0969b.f20437a != TbadkCoreApplication.getInst().getSkinType()) {
                K.isChanged = true;
            }
            c0969b.f20441e.setText(K);
        }
        String userId2 = postData.t().getUserId();
        int i2 = this.f20429g;
        if (i2 != 0) {
            z4 = (i2 == 1002 || i2 == 3) ? false : true;
            z5 = (this.f20429g == 3 || this.k.Q1()) ? false : true;
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
        if (this.f20430h) {
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
                c0969b.f20440d.setVisibility(8);
                sparseArray = (SparseArray) c0969b.f20438b.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    c0969b.f20438b.setTag(sparseArray);
                    c0969b.f20441e.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.n);
                if (!z4) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f20429g));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                sparseArray.put(R.id.tag_clip_board, postData);
                if (!z6) {
                    if (this.k != null) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.k.f0() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.k.f0());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                    }
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z7) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f20429g));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                    sparseArray.put(R.id.tag_del_post_type, 2);
                    sparseArray.put(R.id.tag_del_post_id, postData.E());
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.W()));
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                if (this.l && z2 && this.m) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0969b.f20439c.getLayoutParams();
                    layoutParams.topMargin = l.g(this.f20427e, R.dimen.ds32);
                    layoutParams.bottomMargin = l.g(this.f20427e, R.dimen.ds8);
                    c0969b.f20439c.setLayoutParams(layoutParams);
                }
                if (this.l && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0969b.f20439c.getLayoutParams();
                    layoutParams2.topMargin = l.g(this.f20427e, R.dimen.ds8);
                    layoutParams2.bottomMargin = l.g(this.f20427e, R.dimen.ds8);
                    c0969b.f20439c.setLayoutParams(layoutParams2);
                }
                c0969b.f20440d.setTag(sparseArray);
                c0969b.f20441e.setTag(sparseArray);
                c0969b.f20437a = TbadkCoreApplication.getInst().getSkinType();
                c0969b.f20441e.setOnLongClickListener(this.p);
            }
        }
        z6 = false;
        if (userId2 == null) {
        }
        z7 = z5;
        c0969b.f20440d.setVisibility(8);
        sparseArray = (SparseArray) c0969b.f20438b.getTag();
        if (sparseArray == null) {
        }
        sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.n);
        if (!z4) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        sparseArray.put(R.id.tag_clip_board, postData);
        if (!z6) {
        }
        if (!z7) {
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0969b.f20439c.getLayoutParams();
            layoutParams3.topMargin = l.g(this.f20427e, R.dimen.ds32);
            layoutParams3.bottomMargin = l.g(this.f20427e, R.dimen.ds8);
            c0969b.f20439c.setLayoutParams(layoutParams3);
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0969b.f20439c.getLayoutParams();
            layoutParams22.topMargin = l.g(this.f20427e, R.dimen.ds8);
            layoutParams22.bottomMargin = l.g(this.f20427e, R.dimen.ds8);
            c0969b.f20439c.setLayoutParams(layoutParams22);
        }
        c0969b.f20440d.setTag(sparseArray);
        c0969b.f20441e.setTag(sparseArray);
        c0969b.f20437a = TbadkCoreApplication.getInst().getSkinType();
        c0969b.f20441e.setOnLongClickListener(this.p);
    }

    public final void d(PostData postData, boolean z) {
        TbRichText K;
        SpannableStringBuilder F;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, postData, z) == null) || postData == null || (K = postData.K()) == null) {
            return;
        }
        ArrayList<TbRichTextData> y = K.y();
        if (ListUtils.isEmpty(y)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = y.get(y.size() - 1);
            int type = tbRichTextData != null ? tbRichTextData.getType() : -1;
            if (type == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.R());
                if (y.size() > 1) {
                    if ((y.get(y.size() + (-2)) != null ? y.get(y.size() - 2).getType() : -1) != type) {
                        str2 = StringHelper.getFormatTime(postData.R());
                    }
                }
                SpannableStringBuilder F2 = tbRichTextData.F();
                if (K.hasAppendTime && F2 != 0 && K.appendLength <= F2.length()) {
                    F2.delete(F2.length() - K.appendLength, F2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (F2 != null) {
                    F2.append((CharSequence) str);
                }
                K.hasAppendTime = true;
                K.appendLength = str.length();
            } else if (K.hasAppendTime) {
                str = "";
            } else {
                String formatTime = StringHelper.getFormatTime(postData.R());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.x(forceLToR);
                K.hasAppendTime = true;
                K.appendLength = forceLToR.length();
                y.add(tbRichTextData);
                str = forceLToR;
            }
            SpannableStringBuilder F3 = tbRichTextData.F();
            if (F3 == null || str.length() > F3.length()) {
                return;
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
            F3.setSpan(absoluteSizeSpan, F3.length() - str.length(), F3.length(), 33);
            F3.setSpan(foregroundColorSpan, F3.length() - str.length(), F3.length(), 33);
            return;
        }
        TbRichTextData tbRichTextData2 = y.get(y.size() - 1);
        if (K.hasAppendTime && tbRichTextData2 != null && (F = tbRichTextData2.F()) != null && K.appendLength <= F.length()) {
            F.delete(F.length() - K.appendLength, F.length());
        }
        K.hasAppendTime = false;
        K.appendLength = 0;
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
            this.f20432j = z;
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
        C0969b c0969b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            PostData postData = getItem(i2) instanceof PostData ? (PostData) getItem(i2) : null;
            if (view == null) {
                if (postData.getType() == PostData.A0) {
                    view = a();
                } else {
                    view = b();
                }
            }
            if ((view.getTag() instanceof a) && postData.getType() != PostData.A0) {
                view = b();
            }
            if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.A0) {
                view = a();
            }
            if ((view.getTag() instanceof SparseArray) && (c0969b = (C0969b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
                boolean z = !this.f20431i && i2 + 1 >= getCount();
                boolean z2 = i2 == this.o;
                c(c0969b, postData, !z, i2 == 0, z2);
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
            this.f20428f = onClickListener;
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
            this.f20429g = i2;
            this.f20430h = z;
        }
    }
}
