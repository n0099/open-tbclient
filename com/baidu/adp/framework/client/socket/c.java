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

    public static int a(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    public static e b(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && !next.aI()) {
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

    public static e c(LinkedList<e> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.peek();
    }

    public static e d(LinkedList<e> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.poll();
    }

    public static boolean a(LinkedList<e> linkedList, LinkedList<e> linkedList2, e eVar) {
        if (eVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(eVar)) {
            return false;
        }
        linkedList2.add(eVar);
        return true;
    }

    public static boolean e(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return false;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && next.aI()) {
                next.aK();
                if (next.aJ() >= next.as()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void f(LinkedList<e> linkedList) {
        if (linkedList != null) {
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.ax();
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
            if (next != null && next.aH() == i) {
                it.remove();
                next.ay();
                return next;
            }
        }
        return null;
    }

    public static boolean b(LinkedList<e> linkedList, int i) {
        SocketMessage aE;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (aE = next.aE()) != null && aE.getCmd() == i) {
                return true;
            }
        }
        return false;
    }

    public static void c(LinkedList<e> linkedList, int i) {
        SocketMessage aE;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (aE = next.aE()) != null && aE.getCmd() == i) {
                it.remove();
            }
        }
    }

    public static boolean a(LinkedList<e> linkedList, a aVar, int i) {
        SocketMessage aE;
        if (aVar == null) {
            return false;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (aE = next.aE()) != null && aE.getCmd() == i && aVar.onFindMessage(aE)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(LinkedList<e> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage aE;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (aE = next.aE()) != null && ((i != 0 && aE.getTag() == bdUniqueId && i == aE.getCmd()) || (i == 0 && bdUniqueId != null && aE.getTag() == bdUniqueId))) {
                return true;
            }
        }
        return false;
    }

    public static void b(LinkedList<e> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage aE;
        if (linkedList != null) {
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null && (aE = next.aE()) != null && ((i != 0 && aE.getTag() == bdUniqueId && i == aE.getCmd()) || (i == 0 && bdUniqueId != null && aE.getTag() == bdUniqueId))) {
                    it.remove();
                    next.ay();
                }
            }
        }
    }
}
