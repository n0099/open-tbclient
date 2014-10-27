package com.baidu.tbadk.core.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bn {
    private static int Fx = -1;
    private static int Fy = -1;
    private static boolean Fz = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> FA = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    public static void u(Context context) {
        mAppContext = context;
        Fz = true;
    }

    private static void mS() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            Fy = mAppContext.getResources().getColor(com.baidu.tieba.s.more_color);
            Fx = mAppContext.getResources().getColor(com.baidu.tieba.s.skin_1_common_color);
        }
    }

    private static int bC(int i) {
        return W(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int W(boolean z) {
        if (Fz) {
            Fz = false;
            mS();
        }
        return z ? Fx : Fy;
    }

    public static void m(View view) {
        if (view instanceof ViewGroup) {
            a((ViewGroup) view, TbadkApplication.m251getInst().getSkinType());
        }
    }

    public static void n(View view) {
        if (view != null) {
            FA.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void a(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = FA.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            b(viewGroup, i);
            FA.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, bp bpVar) {
        if (!z || !bpVar.k(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!bpVar.k(childAt)) {
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

    private static void b(ViewGroup viewGroup, int i) {
        a(viewGroup, true, new bo(i, i == 1));
    }

    public static void j(View view, int i) {
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
                aw.h(view, com.baidu.tieba.u.auto_skin_list_item_bg_up);
            } else if (i == 2) {
                aw.h(view, com.baidu.tieba.u.auto_skin_list_item_bg_down);
            } else {
                aw.h(view, com.baidu.tieba.u.list_selector_item);
            }
        }
    }

    public static void l(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }

    public static void b(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(bC(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(bC(i));
        }
    }
}
