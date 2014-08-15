package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    public static boolean a(g gVar, LinkedList<g> linkedList) {
        int c;
        if (gVar == null || linkedList == null || (c = c(gVar, linkedList)) < 0 || c > linkedList.size()) {
            return false;
        }
        linkedList.add(c, gVar);
        return true;
    }

    public static boolean a(LinkedList<g> linkedList, LinkedList<g> linkedList2) {
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            g poll = linkedList2.poll();
            if (poll != null) {
                a(poll, linkedList);
            } else {
                return true;
            }
        }
    }

    public static int a(LinkedList<g> linkedList) {
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    public static g b(LinkedList<g> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && !next.o()) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean b(g gVar, LinkedList<g> linkedList) {
        if (gVar == null || linkedList == null) {
            return false;
        }
        return linkedList.remove(gVar);
    }

    public static int c(g gVar, LinkedList<g> linkedList) {
        if (gVar == null || linkedList == null) {
            return -1;
        }
        int size = linkedList.size();
        int i = 0;
        while (i < size && linkedList.get(i).i() <= gVar.i()) {
            i++;
        }
        return i;
    }

    public static g c(LinkedList<g> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.peek();
    }

    public static g d(LinkedList<g> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.poll();
    }

    public static boolean a(LinkedList<g> linkedList, LinkedList<g> linkedList2, g gVar) {
        if (gVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(gVar)) {
            return false;
        }
        linkedList2.add(gVar);
        return true;
    }

    public static boolean e(LinkedList<g> linkedList) {
        if (linkedList == null) {
            return false;
        }
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.o()) {
                next.q();
                if (next.p() >= next.a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void f(LinkedList<g> linkedList) {
        if (linkedList != null) {
            Iterator<g> it = linkedList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next != null) {
                    next.b();
                }
            }
        }
    }

    public static g a(int i, LinkedList<g> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.n() == i) {
                it.remove();
                next.c();
                return next;
            }
        }
        return null;
    }

    public static boolean a(LinkedList<g> linkedList, int i) {
        SocketMessage j;
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && (j = next.j()) != null && j.getCmd() == i) {
                return true;
            }
        }
        return false;
    }

    public static void b(LinkedList<g> linkedList, int i) {
        SocketMessage j;
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && (j = next.j()) != null && j.getCmd() == i) {
                it.remove();
            }
        }
    }

    public static boolean a(LinkedList<g> linkedList, a aVar, int i) {
        SocketMessage j;
        if (aVar == null) {
            return false;
        }
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && (j = next.j()) != null && j.getCmd() == i && aVar.onFindMessage(j)) {
                return true;
            }
        }
        return false;
    }

    public static void a(LinkedList<g> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage j;
        if (linkedList != null) {
            Iterator<g> it = linkedList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next != null && (j = next.j()) != null && ((i != 0 && j.getTag() == bdUniqueId && i == j.getCmd()) || (i == 0 && bdUniqueId != null && j.getTag() == bdUniqueId))) {
                    it.remove();
                    next.c();
                }
            }
        }
    }
}
