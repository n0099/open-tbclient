package c.a.p0.w2.m.h;

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
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f20374b;

    /* renamed from: c  reason: collision with root package name */
    public int f20375c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20376d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20377e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20378f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadData f20379g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20380h;
    public boolean i;
    public String j;
    public int k;
    public View.OnLongClickListener l;
    public View.OnClickListener m;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f20381b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20382c;

        /* renamed from: d  reason: collision with root package name */
        public View f20383d;

        public a(Context context, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.f20383d = view;
            this.f20381b = view.findViewById(R.id.obfuscated_res_0x7f0907f4);
            TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0905d9);
            this.f20382c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != this.a) {
                    SkinManager.setBackgroundColor(this.f20381b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(this.f20382c, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(this.f20382c, R.color.CAM_X0201);
                    this.f20382c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
                }
                this.a = i;
            }
        }
    }

    /* renamed from: c.a.p0.w2.m.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1520b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f20384b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f20385c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f20386d;

        /* renamed from: e  reason: collision with root package name */
        public TbRichTextView f20387e;

        /* renamed from: f  reason: collision with root package name */
        public View f20388f;

        public C1520b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f20374b = null;
        this.f20375c = 0;
        this.f20376d = false;
        this.f20377e = false;
        this.f20378f = true;
        this.f20380h = false;
        this.i = false;
        this.j = "";
        this.k = -1;
        this.l = null;
        this.m = null;
        this.a = context;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0608, (ViewGroup) null);
            inflate.setTag(new a(this.a, inflate));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            C1520b c1520b = new C1520b();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0609, (ViewGroup) null);
            c1520b.f20384b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091dc5);
            c1520b.f20385c = linearLayout;
            if (this.f20380h) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
                layoutParams.bottomMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
                c1520b.f20385c.setLayoutParams(layoutParams);
            }
            c1520b.f20386d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091387);
            c1520b.f20387e = (TbRichTextView) inflate.findViewById(R.id.obfuscated_res_0x7f09155d);
            c1520b.f20388f = inflate.findViewById(R.id.obfuscated_res_0x7f0907d9);
            c1520b.f20387e.getLayoutStrategy().t();
            if (!this.f20380h) {
                c1520b.f20387e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                c1520b.f20387e.getLayoutStrategy().j(0);
                c1520b.f20387e.getLayoutStrategy().l(n.f(this.a, R.dimen.tbds20));
                c1520b.f20387e.getLayoutStrategy().m(n.f(this.a, R.dimen.tbds14));
                c1520b.f20387e.setMaxLines(4);
                c1520b.f20387e.setTextEllipsize(TextUtils.TruncateAt.END);
                c1520b.f20387e.setAddTruncateListener(true);
                c1520b.f20387e.setTextSize(TbConfig.getOutterSubpbContentSize());
            } else {
                c1520b.f20387e.setTextSize(TbConfig.getContentSizeOfLzl());
            }
            c1520b.f20387e.setSubPbPost(true);
            c1520b.f20387e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            c1520b.f20387e.setIsNeedResizeEmotion(true);
            c1520b.f20387e.setTextCenter(true);
            c1520b.f20387e.setOnClickListener(this.m);
            c1520b.f20386d.setOnClickListener(this.f20374b);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f091e7e, c1520b);
            inflate.setTag(sparseArray);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(C1520b c1520b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{c1520b, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || c1520b == null || postData == null) {
            return;
        }
        boolean z7 = true;
        boolean z8 = false;
        if (!postData.Y) {
            Context context = this.a;
            if (context instanceof c.a.p0.w2.m.a) {
                c.a.p0.w2.m.a aVar = (c.a.p0.w2.m.a) context;
                postData.G0(aVar.getPageContext(), postData.s() != null && aVar.isHost(postData.s().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(c1520b.f20384b, R.color.CAM_X0204);
        } else {
            c1520b.f20384b.setBackgroundResource(0);
        }
        if (postData.e0()) {
            c1520b.f20388f.setVisibility(0);
        } else {
            c1520b.f20388f.setVisibility(8);
        }
        c1520b.f20387e.setPadding(0, 0, 0, 0);
        if (postData.s() != null) {
            String name_show = postData.s().getName_show();
            String userId = postData.s().getUserId();
            String portrait = postData.s().getPortrait();
            SparseArray sparseArray2 = (SparseArray) c1520b.f20384b.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                c1520b.f20384b.setTag(sparseArray2);
                c1520b.f20387e.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f091e99, name_show);
            sparseArray2.put(R.id.obfuscated_res_0x7f091e98, userId);
            sparseArray2.put(R.id.obfuscated_res_0x7f091e97, portrait);
            sparseArray2.put(R.id.obfuscated_res_0x7f091e69, postData);
            sparseArray2.put(R.id.obfuscated_res_0x7f091e82, Boolean.TRUE);
        }
        c1520b.f20387e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
        c1520b.f20387e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        d(postData, this.f20380h);
        TbRichText N = postData.N();
        if (N != null) {
            c1520b.f20387e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08b2);
            c1520b.f20387e.setIsFromCDN(this.f20378f);
            if (c1520b.a != TbadkCoreApplication.getInst().getSkinType()) {
                N.isChanged = true;
            }
            c1520b.f20387e.setText(N);
        }
        String userId2 = postData.s().getUserId();
        int i = this.f20375c;
        if (i != 0) {
            z4 = (i == 1002 || i == 3) ? false : true;
            z5 = (this.f20375c == 3 || this.f20379g.isBjh()) ? false : true;
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
        if (this.f20376d) {
            if (!this.f20379g.isBjh()) {
                z5 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = true;
                } else {
                    z7 = z5;
                }
                c1520b.f20386d.setVisibility(8);
                sparseArray = (SparseArray) c1520b.f20384b.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    c1520b.f20384b.setTag(sparseArray);
                    c1520b.f20387e.setTag(sparseArray);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091eb0, this.j);
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(this.f20375c));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e76, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e77, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e78, postData.s().getPortrait());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091e79, postData.G());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e79, postData.G());
                sparseArray.put(R.id.obfuscated_res_0x7f091e69, postData);
                if (!z6) {
                    if (this.f20379g != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f091e80, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f091eba, postData.s().getUserId());
                            sparseArray.put(R.id.obfuscated_res_0x7f091ebb, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f091eb9, postData.s().getName_show());
                        }
                        if (this.f20379g.getId() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f091ebd, this.f20379g.getId());
                        }
                        sparseArray.put(R.id.obfuscated_res_0x7f091ebc, postData.G());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                }
                if (!z7) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(this.f20375c));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z8));
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6d, 2);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6b, postData.G());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e7d, Boolean.valueOf(postData.b0()));
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                }
                if (this.f20380h && z2 && this.i) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1520b.f20385c.getLayoutParams();
                    layoutParams.topMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f070207);
                    layoutParams.bottomMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
                    c1520b.f20385c.setLayoutParams(layoutParams);
                }
                if (this.f20380h && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c1520b.f20385c.getLayoutParams();
                    layoutParams2.topMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
                    layoutParams2.bottomMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
                    c1520b.f20385c.setLayoutParams(layoutParams2);
                }
                c1520b.f20386d.setTag(sparseArray);
                c1520b.f20387e.setTag(sparseArray);
                c1520b.a = TbadkCoreApplication.getInst().getSkinType();
                c1520b.f20387e.setOnLongClickListener(this.l);
            }
        }
        z6 = false;
        if (userId2 == null) {
        }
        z7 = z5;
        c1520b.f20386d.setVisibility(8);
        sparseArray = (SparseArray) c1520b.f20384b.getTag();
        if (sparseArray == null) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091eb0, this.j);
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091e79, postData.G());
        sparseArray.put(R.id.obfuscated_res_0x7f091e69, postData);
        if (!z6) {
        }
        if (!z7) {
        }
        if (this.f20380h) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c1520b.f20385c.getLayoutParams();
            layoutParams3.topMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f070207);
            layoutParams3.bottomMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
            c1520b.f20385c.setLayoutParams(layoutParams3);
        }
        if (this.f20380h) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c1520b.f20385c.getLayoutParams();
            layoutParams22.topMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
            layoutParams22.bottomMargin = n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb);
            c1520b.f20385c.setLayoutParams(layoutParams22);
        }
        c1520b.f20386d.setTag(sparseArray);
        c1520b.f20387e.setTag(sparseArray);
        c1520b.a = TbadkCoreApplication.getInst().getSkinType();
        c1520b.f20387e.setOnLongClickListener(this.l);
    }

    public final void d(PostData postData, boolean z) {
        TbRichText N;
        SpannableStringBuilder I;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, postData, z) == null) || postData == null || (N = postData.N()) == null) {
            return;
        }
        ArrayList<TbRichTextData> A = N.A();
        if (ListUtils.isEmpty(A)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = A.get(A.size() - 1);
            int type = tbRichTextData != null ? tbRichTextData.getType() : -1;
            if (type == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.V());
                if (A.size() > 1) {
                    if ((A.get(A.size() + (-2)) != null ? A.get(A.size() - 2).getType() : -1) != type) {
                        str2 = StringHelper.getFormatTime(postData.V());
                    }
                }
                SpannableStringBuilder I2 = tbRichTextData.I();
                if (N.hasAppendTime && I2 != 0 && N.appendLength <= I2.length()) {
                    I2.delete(I2.length() - N.appendLength, I2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (I2 != null) {
                    I2.append((CharSequence) str);
                }
                N.hasAppendTime = true;
                N.appendLength = str.length();
            } else if (N.hasAppendTime) {
                str = "";
            } else {
                String formatTime = StringHelper.getFormatTime(postData.V());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.z(forceLToR);
                N.hasAppendTime = true;
                N.appendLength = forceLToR.length();
                A.add(tbRichTextData);
                str = forceLToR;
            }
            SpannableStringBuilder I3 = tbRichTextData.I();
            if (I3 == null || str.length() > I3.length()) {
                return;
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
            I3.setSpan(absoluteSizeSpan, I3.length() - str.length(), I3.length(), 33);
            I3.setSpan(foregroundColorSpan, I3.length() - str.length(), I3.length(), 33);
            return;
        }
        TbRichTextData tbRichTextData2 = A.get(A.size() - 1);
        if (N.hasAppendTime && tbRichTextData2 != null && (I = tbRichTextData2.I()) != null && N.appendLength <= I.length()) {
            I.delete(I.length() - N.appendLength, I.length());
        }
        N.hasAppendTime = false;
        N.appendLength = 0;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f20378f = z;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.j = str;
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
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1520b c1520b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view, viewGroup)) == null) {
            PostData postData = getItem(i) instanceof PostData ? (PostData) getItem(i) : null;
            if (view == null) {
                if (postData.getType() == PostData.B0) {
                    view = a();
                } else {
                    view = b();
                }
            }
            if ((view.getTag() instanceof a) && postData.getType() != PostData.B0) {
                view = b();
            }
            if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.B0) {
                view = a();
            }
            if ((view.getTag() instanceof SparseArray) && (c1520b = (C1520b) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f091e7e)) != null && postData != null) {
                boolean z = !this.f20377e && i + 1 >= getCount();
                boolean z2 = i == this.k;
                c(c1520b, postData, !z, i == 0, z2);
                if (z2) {
                    this.k = -1;
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
            this.f20374b = onClickListener;
        }
    }

    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            this.f20379g = threadData;
        }
    }

    public void j(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f20375c = i;
            this.f20376d = z;
        }
    }
}
