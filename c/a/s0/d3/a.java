package c.a.s0.d3;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static c.a.d.m.d.a t;
    public static String u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f16986e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f16987f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f16988g;

    /* renamed from: h  reason: collision with root package name */
    public final ColumnLayout f16989h;

    /* renamed from: i  reason: collision with root package name */
    public final ColumnLayout f16990i;

    /* renamed from: j  reason: collision with root package name */
    public InterfaceC1040a f16991j;

    /* renamed from: k  reason: collision with root package name */
    public int f16992k;
    public LinearLayout l;
    public HeadImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public TbPageContext<?> s;

    /* renamed from: c.a.s0.d3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1040a {
        void a(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = tbPageContext;
        this.l = (LinearLayout) view.findViewById(c.a.s0.y2.d.top_line);
        this.m = (HeadImageView) view.findViewById(c.a.s0.y2.d.portrait);
        this.n = (TextView) view.findViewById(c.a.s0.y2.d.username);
        this.o = (TextView) view.findViewById(c.a.s0.y2.d.reply_time);
        this.p = (TextView) view.findViewById(c.a.s0.y2.d.forum_name);
        this.q = (TextView) view.findViewById(c.a.s0.y2.d.reply_count);
        this.f16988g = (LinearLayout) view.findViewById(c.a.s0.y2.d.item_content);
        this.f16989h = (ColumnLayout) view.findViewById(c.a.s0.y2.d.item_header);
        this.f16990i = (ColumnLayout) view.findViewById(c.a.s0.y2.d.item_footer);
        this.f16986e = (LinearLayout) view.findViewById(c.a.s0.y2.d.person_thread);
        this.f16987f = (LinearLayout) view.findViewById(c.a.s0.y2.d.person_child);
        this.r = (ImageView) view.findViewById(c.a.s0.y2.d.comment_icon);
        this.f16992k = c.a.d.f.p.m.d(view.getContext(), 42.0f);
        LinearLayout linearLayout = this.f16988g;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.f16989h.setOnClickListener(this);
        this.f16990i.setOnClickListener(this);
        this.q.setText(c.a.s0.y2.g.reply_me);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            SkinManager.setViewTextColor(this.p, c.a.s0.y2.a.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.o, c.a.s0.y2.a.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.n, c.a.s0.y2.a.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.f16986e, c.a.s0.y2.a.CAM_X0204);
            SkinManager.setBackgroundResource(this.f16987f, c.a.s0.y2.a.CAM_X0201);
            TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.q, c.a.s0.y2.a.CAM_X0105);
            WebPManager.setPureDrawable(this.r, c.a.s0.y2.c.icon_pure_card_comment22, c.a.s0.y2.a.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = u;
            if (str2 != null && !str2.equals(str)) {
                t = null;
            }
            c.a.d.m.d.a aVar = t;
            if (aVar != null) {
                this.m.setImageBitmap(aVar.p());
                u = str;
                return;
            }
            HeadImageView headImageView = this.m;
            int i2 = this.f16992k;
            headImageView.startLoad(str, 12, i2, i2, false);
        }
    }

    public void c(InterfaceC1040a interfaceC1040a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1040a) == null) {
            this.f16991j = interfaceC1040a;
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
            this.n.setText(z);
            this.o.setText(charSequence6);
            this.p.setText(charSequence);
            this.p.setTag(charSequence);
            this.q.setText(charSequence7);
            this.q.setTag(strArr);
            this.p.setOnClickListener(this);
            b(str);
            LinearLayout linearLayout = this.f16988g;
            if (linearLayout != null) {
                linearLayout.setTag(strArr);
            }
            this.f16989h.setTag(strArr);
            this.f16990i.setTag(strArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view.getId() == c.a.s0.y2.d.forum_name) {
                TbPageContext<?> tbPageContext = this.s;
                if (tbPageContext != null) {
                    tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.s.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
                    return;
                }
                return;
            }
            InterfaceC1040a interfaceC1040a = this.f16991j;
            if (interfaceC1040a != null) {
                interfaceC1040a.a(view);
            }
        }
    }
}
