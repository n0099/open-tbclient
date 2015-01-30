package com.baidu.tbadk.core.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bu {
    private static int Ka = -1;
    private static int Kb = -1;
    private static boolean Kc = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> Kd = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    public static void S(Context context) {
        mAppContext = context;
        Kc = true;
    }

    private static void pW() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            Kb = mAppContext.getResources().getColor(com.baidu.tieba.t.more_color);
            Ka = mAppContext.getResources().getColor(com.baidu.tieba.t.skin_1_common_color);
        }
    }

    private static int cg(int i) {
        return ap(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ap(boolean z) {
        if (Kc) {
            Kc = false;
            pW();
        }
        return z ? Ka : Kb;
    }

    public static void m(View view) {
        if (view instanceof ViewGroup) {
            b((ViewGroup) view, TbadkCoreApplication.m255getInst().getSkinType());
        }
    }

    public static void n(View view) {
        if (view != null) {
            Kd.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = Kd.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            c(viewGroup, i);
            Kd.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, bw bwVar) {
        if (!z || !bwVar.k(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!bwVar.k(childAt)) {
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
        a(viewGroup, true, new bv(i, i == 1));
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
                bc.i(view, com.baidu.tieba.v.auto_skin_list_item_bg_up);
            } else if (i == 2) {
                bc.i(view, com.baidu.tieba.v.auto_skin_list_item_bg_down);
            } else {
                bc.i(view, com.baidu.tieba.v.list_selector_item);
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
            textView.setTextColor(cg(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(cg(i));
        }
    }
}
