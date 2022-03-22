package c.a.p0.f3;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static c.a.d.o.d.a p;
    public static String q;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f14943b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f14944c;

    /* renamed from: d  reason: collision with root package name */
    public final ColumnLayout f14945d;

    /* renamed from: e  reason: collision with root package name */
    public final ColumnLayout f14946e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1131a f14947f;

    /* renamed from: g  reason: collision with root package name */
    public int f14948g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f14949h;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public TbPageContext<?> o;

    /* renamed from: c.a.p0.f3.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1131a {
        void a(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = tbPageContext;
        this.f14949h = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0920c0);
        this.i = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f0918a4);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922e5);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091a6c);
        this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a67);
        this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091a5c);
        this.f14944c = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090f62);
        this.f14945d = (ColumnLayout) view.findViewById(R.id.obfuscated_res_0x7f090f77);
        this.f14946e = (ColumnLayout) view.findViewById(R.id.obfuscated_res_0x7f090f6d);
        this.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0917fe);
        this.f14943b = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0917a3);
        this.n = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09068b);
        this.f14948g = n.d(view.getContext(), 42.0f);
        LinearLayout linearLayout = this.f14944c;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.f14945d.setOnClickListener(this);
        this.f14946e.setOnClickListener(this);
        this.m.setText(R.string.obfuscated_res_0x7f0f0f8d);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.a, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f14943b, R.color.CAM_X0201);
            TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.n, R.drawable.obfuscated_res_0x7f0808e9, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = q;
            if (str2 != null && !str2.equals(str)) {
                p = null;
            }
            c.a.d.o.d.a aVar = p;
            if (aVar != null) {
                this.i.setImageBitmap(aVar.p());
                q = str;
                return;
            }
            HeadImageView headImageView = this.i;
            int i = this.f14948g;
            headImageView.G(str, 12, i, i, false);
        }
    }

    public void c(InterfaceC1131a interfaceC1131a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1131a) == null) {
            this.f14947f = interfaceC1131a;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x000d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x009c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v9, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r12v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.CharSequence, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        ?? r0 = $ic;
        if (r0 != 0) {
            charSequence = new Object[]{postInfoList, Boolean.valueOf((boolean) z), str};
            if (r0.invokeCommon(1048579, this, charSequence) != null) {
                return;
            }
        }
        String[] strArr = new String[4];
        CharSequence charSequence6 = 1000;
        charSequence6 = 1000;
        boolean z2 = true;
        CharSequence charSequence7 = null;
        try {
            try {
                try {
                    try {
                        if (z != 0) {
                            String str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            String str3 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            charSequence6 = formatTime;
                            charSequence = str3;
                            z = str2;
                        } else {
                            String str4 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            String str5 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            charSequence6 = formatTime2;
                            charSequence = str5;
                            z = str4;
                        }
                    } catch (Exception unused) {
                        charSequence2 = charSequence7;
                        charSequence3 = charSequence2;
                        charSequence5 = charSequence6;
                        charSequence4 = z;
                        charSequence7 = charSequence4;
                        charSequence6 = charSequence5;
                        charSequence = charSequence3;
                        z = charSequence7;
                        z2 = false;
                        charSequence7 = charSequence2;
                        if (z2) {
                        }
                    }
                } catch (Exception unused2) {
                    charSequence2 = null;
                    charSequence6 = null;
                    charSequence = null;
                    z = charSequence7;
                    z2 = false;
                    charSequence7 = charSequence2;
                    if (z2) {
                    }
                }
            } catch (Exception unused3) {
                charSequence2 = charSequence7;
                charSequence5 = charSequence6;
                charSequence3 = charSequence;
                charSequence4 = z;
                charSequence7 = charSequence4;
                charSequence6 = charSequence5;
                charSequence = charSequence3;
                z = charSequence7;
                z2 = false;
                charSequence7 = charSequence2;
                if (z2) {
                }
            }
        } catch (Exception unused4) {
            charSequence2 = charSequence7;
            CharSequence charSequence8 = charSequence2;
            charSequence3 = charSequence8;
            charSequence5 = charSequence8;
            charSequence4 = z;
            charSequence7 = charSequence4;
            charSequence6 = charSequence5;
            charSequence = charSequence3;
            z = charSequence7;
            z2 = false;
            charSequence7 = charSequence2;
            if (z2) {
            }
        }
        if (z2) {
            this.j.setText(z);
            this.k.setText(charSequence6);
            this.l.setText(charSequence);
            this.l.setTag(charSequence);
            this.m.setText(charSequence7);
            this.m.setTag(strArr);
            this.l.setOnClickListener(this);
            b(str);
            LinearLayout linearLayout = this.f14944c;
            if (linearLayout != null) {
                linearLayout.setTag(strArr);
            }
            this.f14945d.setTag(strArr);
            this.f14946e.setTag(strArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f090a67) {
                TbPageContext<?> tbPageContext = this.o;
                if (tbPageContext != null) {
                    tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.o.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
                    return;
                }
                return;
            }
            InterfaceC1131a interfaceC1131a = this.f14947f;
            if (interfaceC1131a != null) {
                interfaceC1131a.a(view);
            }
        }
    }
}
