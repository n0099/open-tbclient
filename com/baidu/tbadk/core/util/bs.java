package com.baidu.tbadk.core.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bs {
    private static int VL = -1;
    private static int VM = -1;
    private static boolean VN = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> VO = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    public static void ab(Context context) {
        mAppContext = context;
        VN = true;
    }

    private static void tm() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            VM = mAppContext.getResources().getColor(com.baidu.tieba.s.more_color);
            VL = mAppContext.getResources().getColor(com.baidu.tieba.s.skin_1_common_color);
        }
    }

    private static int ci(int i) {
        return aj(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int aj(boolean z) {
        if (VN) {
            VN = false;
            tm();
        }
        return z ? VL : VM;
    }

    public static void m(View view) {
        if (view instanceof ViewGroup) {
            b((ViewGroup) view, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    public static void n(View view) {
        if (view != null) {
            VO.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = VO.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            c(viewGroup, i);
            VO.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, bu buVar) {
        if (!z || !buVar.k(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!buVar.k(childAt)) {
                        if (childAt instanceof ViewGroup) {
                            linkedList.addLast((ViewGroup) childAt);
                        }
                    } else {
                        return;
                    }
                }
                if (!linkedList.isEmpty()) {
                    viewGroup = (ViewGroup) linkedList.removeFirst();
                } else {
                    return;
                }
            }
        }
    }

    private static void c(ViewGroup viewGroup, int i) {
        a(viewGroup, true, new bt(i, i == 1));
    }

    public static void k(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundColor(-14078923);
            } else {
                view.setBackgroundColor(-1183760);
            }
        }
    }

    public static void e(View view, int i, int i2) {
        if (view != null) {
            view.setBackgroundDrawable(null);
            if (i == 0) {
                ba.i(view, com.baidu.tieba.u.auto_skin_list_item_bg_up);
            } else if (i == 2) {
                ba.i(view, com.baidu.tieba.u.auto_skin_list_item_bg_down);
            } else {
                ba.i(view, com.baidu.tieba.u.list_selector_item);
            }
        }
    }

    public static void k(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(ci(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(ci(i));
        }
    }
}
