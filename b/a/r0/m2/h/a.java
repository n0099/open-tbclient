package b.a.r0.m2.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f21186a;

    /* renamed from: b  reason: collision with root package name */
    public int f21187b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f21188c;

    /* renamed from: d  reason: collision with root package name */
    public String f21189d;

    /* renamed from: e  reason: collision with root package name */
    public String f21190e;

    /* renamed from: f  reason: collision with root package name */
    public String f21191f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        this.f21186a = tbBookrack.booktown;
        this.f21187b = tbBookrack.num.intValue();
        this.f21189d = tbBookrack.title;
        this.f21190e = tbBookrack.icon;
        this.f21191f = tbBookrack.tip;
        this.f21188c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f21188c.add(bVar);
                }
            }
        }
    }
}
