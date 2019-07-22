package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    public static boolean a(e eVar, LinkedList<e> linkedList) {
        int c;
        if (eVar == null || linkedList == null || (c = c(eVar, linkedList)) < 0 || c > linkedList.size()) {
            return false;
        }
        linkedList.add(c, eVar);
        return true;
    }

    public static boolean a(LinkedList<e> linkedList, LinkedList<e> linkedList2) {
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            e poll = linkedList2.poll();
            if (poll != null) {
                a(poll, linkedList);
            } else {
                return true;
            }
        }
    }

    public static int c(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    public static e d(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && !next.fF()) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean b(e eVar, LinkedList<e> linkedList) {
        if (eVar == null || linkedList == null) {
            return false;
        }
        return linkedList.remove(eVar);
    }

    public static int c(e eVar, LinkedList<e> linkedList) {
        if (eVar == null || linkedList == null) {
            return -1;
        }
        int size = linkedList.size();
        int i = 0;
        while (i < size && linkedList.get(i).getPriority() <= eVar.getPriority()) {
            i++;
        }
        return i;
    }

    public static e e(LinkedList<e> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.peek();
    }

    public static e f(LinkedList<e> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.poll();
    }

    public static boolean a(LinkedList<e> linkedList, LinkedList<e> linkedList2, e eVar) {
        if (eVar == null || linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.remove(eVar)) {
            linkedList2.add(eVar);
            return true;
        }
        return false;
    }

    public static boolean g(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return false;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && next.fF()) {
                next.fH();
                if (next.fG() >= next.fo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void h(LinkedList<e> linkedList) {
        if (linkedList != null) {
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.fu();
                }
            }
        }
    }

    public static e a(int i, LinkedList<e> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && next.fE() == i) {
                it.remove();
                next.fv();
                return next;
            }
        }
        return null;
    }

    public static boolean b(LinkedList<e> linkedList, int i) {
        SocketMessage fB;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (fB = next.fB()) != null && fB.getCmd() == i) {
                return true;
            }
        }
        return false;
    }

    public static void c(LinkedList<e> linkedList, int i) {
        SocketMessage fB;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (fB = next.fB()) != null && fB.getCmd() == i) {
                it.remove();
            }
        }
    }

    public static boolean a(LinkedList<e> linkedList, a aVar, int i) {
        SocketMessage fB;
        if (aVar == null) {
            return false;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (fB = next.fB()) != null && fB.getCmd() == i && aVar.onFindMessage(fB)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(LinkedList<e> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage fB;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (fB = next.fB()) != null && ((i != 0 && fB.getTag() == bdUniqueId && i == fB.getCmd()) || (i == 0 && bdUniqueId != null && fB.getTag() == bdUniqueId))) {
                return true;
            }
        }
        return false;
    }

    public static void b(LinkedList<e> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage fB;
        if (linkedList != null) {
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null && (fB = next.fB()) != null && ((i != 0 && fB.getTag() == bdUniqueId && i == fB.getCmd()) || (i == 0 && bdUniqueId != null && fB.getTag() == bdUniqueId))) {
                    it.remove();
                    next.fv();
                }
            }
        }
    }
}
